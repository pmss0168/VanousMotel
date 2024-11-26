<%-- 
    Document   : pagination
    Created on : Mar 22, 2024, 11:34:05 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <style>
            .pagination li{
                padding: 10px;
                border: 1px solid #000;
            }
            .active{
                background-color: #db2a34;
                color: white;
            }
        </style>
        <ul class="pagination" style="list-style: none;display: flex; justify-content: center; gap: 10px;">
            <li>first</li>
            <li>second</li>
            <li>third</li>
        </ul>
        <script>
            //pagination
            let thisPage = 1;
            let limit = 8;
            let list = document.querySelectorAll(".list .item");
            function loadItem() {
                let beginGet = limit * (thisPage - 1);
                let endGet = limit * thisPage - 1;
                list.forEach((item, key) => {
                    if (key >= beginGet && key <= endGet) {
                        item.style.display = "flex";
                    } else {
                        item.style.display = "none";
                    }
                });
                listPage();
            }
            loadItem();
            function listPage() {
                let max = Math.ceil(list.length / limit);
                document.querySelector(".pagination").innerHTML = '';
                if (thisPage !== 1) {
                    let prev = document.createElement("li");
                    prev.innerHTML = '<span aria-hidden="true">&laquo;</span>';
                    prev.setAttribute('onclick', 'changePage(' + (thisPage - 1) + ')');
                    document.querySelector('.pagination').appendChild(prev);
                }
                for (i = 1; i <= max; i++) {
                    let newPage = document.createElement("li");
                    newPage.innerHTML = i;
                    if (i === thisPage) {
                        newPage.classList.add('active');
                    }
                    newPage.setAttribute('onclick', 'changePage(' + i + ')');
                    document.querySelector('.pagination').appendChild(newPage);
                }
                if (thisPage !== max) {
                    let next = document.createElement("li");
                    next.innerHTML = '<span aria-hidden="true">&raquo;</span>';
                    next.setAttribute('onclick', 'changePage(' + (thisPage + 1) + ')');
                    document.querySelector('.pagination').appendChild(next);
                }
            }
            function changePage(i) {
                thisPage = i;
                loadItem();
            }
        </script>
