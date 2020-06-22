
const bookForm = document.querySelector('.js-regForm');
const uid = bookForm.querySelector('#uid');
const upw = bookForm.querySelector('#upw');
const uname = bookForm.querySelector('#uname');
const tblList = document.querySelector('.tblList');
const tbody = document.querySelector('.tbody');

let books = [];


// 객체 삭제
function deleteBook(event) {
    const btn = event.target;
    const tr = btn.parentNode;
    tbody.removeChild(tr);
    const cleanBooks = books.filter(function (book) {
        return book.idx !== parseInt(tr.idx);
    });
    books = cleanBooks;
    saveBooks();
}



// 회원 정보 객체 생성

function createBooks(idx, id, pw, name) {

    return {
        idx: idx,
        id: id,
        pw: pw,
        name: name
    }

}


//로컬 스토리지에 배열객체 저장
function saveBooks() {
    localStorage.setItem('books', JSON.stringify(books));
}

function submitBook(e) {

    e.preventDefault();
    const currentIdx = books.length;
    const currentId = uid.value;
    const currentPw = upw.value;
    const currentName = uname.value;

    const bookObj = createBooks(currentIdx, currentId, currentPw, currentName);

    books.push(bookObj);

    tbody.innerHTML = "";
    list();

    saveBooks();
    uid.value = "";
    upw.value = "";
    uname.value = "";
};

// 회원 리스트 출력
function paintBook(books) {
    console.log(books.idx);
    console.log(books.id);
    console.log(books.pw);
    console.log(books.name);

    const tr = tbody.appendChild(document.createElement('tr'));

    const td1 = tr.appendChild(document.createElement('td'));
    const td2 = tr.appendChild(document.createElement('td'));
    const td3 = tr.appendChild(document.createElement('td'));
    const td4 = tr.appendChild(document.createElement('td'));
    const td5 = tr.appendChild(document.createElement('td'));

    td1.appendChild(document.createTextNode(books.idx));
    td2.appendChild(document.createTextNode(books.id));
    td3.appendChild(document.createTextNode(books.pw));
    td4.appendChild(document.createTextNode(books.name));
    const btn = td5.appendChild(document.createElement('btn'));
    btn.appendChild(document.createTextNode('❌'));
    btn.addEventListener('click', deleteBook);

};

// 배열 안 리스트 출력
function list() {
    books.forEach(function (e) {
        // console.log(e.length);
        paintBook(e);
    });
}

// 로컬스토리지 불러와 배열에 저장
function loadBooks() {
    const loadedBooks = localStorage.getItem('books');
    if (loadedBooks !== null) {
        books = JSON.parse(loadedBooks);
    }
};



// 실행 초기화
function init() {
    loadBooks();
    list();
    bookForm.addEventListener('submit', submitBook);
};

// 실행
init();