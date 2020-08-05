package com.aia.op.member.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.aia.op.member.dao.JdbcTemplateMemberDao;

@Service
public class IdCheckService {

	@Inject
	private JdbcTemplateMemberDao dao;

	public String checkId(String uid) throws SQLException {

		String result = "N";


			int resultCnt = dao.selectById(uid);

			if (resultCnt < 1) {
				result = "Y";
			}

		return result;

	}

}
