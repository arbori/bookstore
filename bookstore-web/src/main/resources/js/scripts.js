/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
function gbooks_query() {
    let query = document.getElementById('gbooks-query-field').value;

    fetch('/gbooks/api/list?query='+query)
        .then(response => response.json())
        .then(volumeList => {
            const gbookListElement = document.getElementById('gbooks-list');

            if(!volumeList.isEmpty) {
                gbookListElement.innerHTML = '';

                volumeList.items.forEach(volume => {
                    let bookElement = document.createElement('div');
                    bookElement.setAttribute("class", "col mb-5");
                    
                    let bookCard = document.createElement("div");
                    bookElement.appendChild(bookCard);
                    bookCard.setAttribute("class", "card h-100");
    
                    let bookImage = document.createElement("img");
                    bookCard.appendChild(bookImage);
                    bookImage.setAttribute("class", "card-img-top");
                    bookImage.setAttribute("src", volume.smallThumbnail);

                    let bookCardBody = document.createElement("div");
                    bookCard.appendChild(bookCardBody);
                    bookCardBody.setAttribute("class", "card-body p-4");
    
                    let bookCardBodyContent = document.createElement("div");
                    bookCardBody.appendChild(bookCardBodyContent);
                    bookCardBodyContent.setAttribute("class", "text-center");
    
                    let bookCardBodyContentH5 = document.createElement("h5");
                    bookCardBodyContent.appendChild(bookCardBodyContentH5);
                    bookCardBodyContentH5.setAttribute("class", "fw-bolder");
    
                    let bookCardBodyContentText = document.createElement("div");
                    bookCardBodyContent.appendChild(bookCardBodyContentText);
                    bookCardBodyContentText.innerHTML = volume.title;

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
