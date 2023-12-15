/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
let favorite_prefix_size = 9

async function onchange_favorite(self) {
    if(self.currentTarget.type !== undefined && self.currentTarget.type == 'checkbox') {
        let id = self.currentTarget.id.substring(favorite_prefix_size);

        let favoritejson = document.getElementById('divjson_' + id).innerHTML;

        await fetch('/gbooks/api/favorite', {
            method: "PUT",
            mode: "cors",
            cache: "no-cache",
            credentials: "same-origin",
            headers: {
                "Content-Type": "application/json",
            },
            redirect: "follow",
            referrerPolicy: "no-referrer",
            body: favoritejson,
        })        
        .then(response => response.json())
        .then(message => {
            if(id !== message.id) {
                alert('The favorite was not saved because an error.');
            }
        });
  
    }
    else {
        alert("It is not the damn favorite checkbox.");
    }
}

function config_page() {
    document.getElementById('gbooks-startIndex-field').value = "0";
    document.getElementById('gbooks-maxResults-field').value = "12";
}

function gbooks_search() {
    let query = document.getElementById('gbooks-query-field').value
    let startIndex = parseInt(document.getElementById('gbooks-startIndex-field').value, 10);
    let maxResults = parseInt(document.getElementById('gbooks-maxResults-field').value, 10);

    gbooks_query(query, startIndex, maxResults);
}

function gbooks_page_back() {
    let query = document.getElementById('gbooks-query-field').value

    let maxResults = parseInt(document.getElementById('gbooks-maxResults-field').value, 10);

    let startIndex = parseInt(document.getElementById('gbooks-startIndex-field').value, 10) - parseInt(maxResults, 10);

    if(startIndex < 0) {
        startIndex = 0;
    }

    gbooks_query(query, startIndex, maxResults);
}

function gbooks_page_forward() {
    let query = document.getElementById('gbooks-query-field').value

    let maxResults = document.getElementById('gbooks-maxResults-field').value;

    let startIndex = parseInt(document.getElementById('gbooks-startIndex-field').value, 10) + parseInt(maxResults, 10);
    
    gbooks_query(query, startIndex, maxResults);
}

function gbooks_query(query, startIndex, maxResults) {
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
    
                    let bookCardTitle = document.createElement("div");
                    bookCardBodyContentText.appendChild(bookCardTitle);
                    bookCardTitle.innerHTML = volume.title;
    
                    let bookCardCheckbox = document.createElement("input");
                    bookCardBodyContentText.appendChild(bookCardCheckbox);
                    bookCardCheckbox.type="checkbox";
                    bookCardCheckbox.id="checkbox_" + volume.id;
                    bookCardCheckbox.name="checkbox_" + volume.id;
                    bookCardCheckbox.value="Favorite";
                    bookCardCheckbox.checked=volume.favorite;
                    bookCardCheckbox.onchange=onchange_favorite;

                    let bookCardJSON = document.createElement("div");
                    bookCardBodyContentText.appendChild(bookCardJSON);
                    bookCardJSON.id="divjson_" + volume.id;
                    bookCardJSON.style.display = 'none';
                    bookCardJSON.innerHTML = JSON.stringify(volume);

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
