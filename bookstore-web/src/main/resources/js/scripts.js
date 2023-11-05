/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
function gbooks_list() {
    fetch('/gbooks/api/list')
        .then(response => response.json())
        .then(gbookslist => {
            const gbookListElement = document.getElementById('gbooks-list');

            if(gbookslist.kind == "books#volumes") {
                gbookListElement.innerHTML = '';

                gbookslist.items.forEach(book => {
                    let bookElement = document.createElement('div');
                    bookElement.setAttribute("class", "col mb-5");
                    
                    let bookCard = bookElement.createElement("div");
                    bookCard.setAttribute("class", "card h-100");

                    let bookImage = bookCard.createElement("image");
                    bookImage.setAttribute("class", "card-img-top");
                    bookImage.setAttribute("src", book.imageLinks.smallThumbnail);

                    let bookCardBody = bookCard.createElement("div");
                    bookCardBody.setAttribute("class", "card-body p-4");

                    let bookCardBodyContent = bookCardBody.createElement("div");
                    bookCardBodyContent.setAttribute("class", "text-center");

                    let bookCardBodyContentH5 = bookCardBodyContent.createElement("h5");
                    bookCardBodyContentH5.setAttribute("class", "fw-bolder");

                    let bookCardBodyContentText = bookCardBodyContent.createElement("div");
                    bookCardBodyContentText.innerHTML = book.volumeInfo.title;

                    gbookListElement.appendChild(bookElement);
                });
            }
            else {
                gbookListElement.innerHTML = 'There is no books to show!';
            }
        })
        .catch(error => {
            console.error('Erro ao carregar a lista de livros:', error);
        });
}

// Chame a função para carregar os livros quando a página carregar
window.onload = carregarLivros;