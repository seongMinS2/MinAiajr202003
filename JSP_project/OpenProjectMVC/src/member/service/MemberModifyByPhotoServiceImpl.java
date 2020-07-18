package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberModifyByPhotoServiceImpl implements Service {

	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// 사진 수정
		// DB의 파일 경로를 읽어와 이전의 사진파일을 삭제후
		// 새로운 파일의 경로를 받아와 DB를 먼저 수정(문제시 롤백용의)
		// 새로운파일을 물리적 위치에 업로드

		int resultCnt = 0;

		int idx = 0;
		String oldPhoto = null;
		String newPhoto = null;

		ServletContext context = request.getSession().getServletContext();
		String realPath = null;

		Member member = null;

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			dao = MemberDao.getInstance();

			// 1. multiport/form-data 여부 확인
			boolean isMulstipart = ServletFileUpload.isMultipartContent(request);

			if (isMulstipart) {
				// 2. 메모리나 파일로 업로드 파일을 보관하는 FileItem의 Factory 설정
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 3. 업로드 요청을 처리하는 ServletFileUpload 생성
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 4. 업로드 요청 파싱해서 FileItem 목록 구함
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> ite = items.iterator();

				while (ite.hasNext()) {

					FileItem item = ite.next();

					// isFormField() : text value를 가지는 input 확인
					if (item.isFormField()) {

						// 파라미터 이름
						String paramName = item.getFieldName();
						// 파라미터의 값
						String paramValue = item.getString("utf-8");

						if (paramName.equals("idx")) {
							idx = Integer.parseInt(paramValue);
						} else if (paramName.equals("uphoto")) {
							oldPhoto = paramValue;

						}

					} else {
						// 파일 선 삭제

						System.out.println("삭제할 경로: " + oldPhoto);
						// 이전 파일의 절대경로
						String oldPath = context.getRealPath(oldPhoto);

						File deletefile = new File(oldPath);

						// 파일이 종료상태이거나 존재 할 경우 삭제
						if (deletefile.exists() && deletefile.isFile()) {

							deletefile.delete(); // 파일 삭제

						}
						
						if (!deletefile.isFile()) {

							// 파일 생성
							String paramName = item.getFieldName();
							System.out.println("type=File인 태그의 이름 : " + paramName);
							String paramValue = item.getString("utf-8");
							System.out.println("type=File인 태그의 값 : " + paramValue);
							// 서버 내부의 경로
							String uri = "/upload/users";

							realPath = context.getRealPath(uri);

							String newFileName = System.nanoTime() + "_" + item.getName();

							// 사진의 새로운 경로 db에 먼저 수정
							newPhoto = uri + "/" + newFileName;

							resultCnt = dao.modifyByPhoto(conn, idx, newPhoto);

							request.setAttribute("resultCnt", resultCnt);

							// 사진 업로드
							File saveFile = new File(realPath, newFileName);
							item.write(saveFile);
							System.out.println("새로운 사진 업로드 완료");

							conn.commit();

						} else {

							conn.rollback();
							throw new Exception();
						}

					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "/WEB-INF/views/member/modify.jsp";
	}
}
