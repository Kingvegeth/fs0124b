        fetch('https://striveschool-api.herokuapp.com/books')
            .then(response => response.json())
            .then(data => {
                const booksContainer = document.querySelector('.row');
                
                data.forEach(book => {
                    const card = document.createElement('div');
                    card.classList.add('col', 'mb-4');

                    card.innerHTML = `
                        <div class="card h-100">
                            <img src="${book.img}" class="card-img-top" alt="${book.title}">
                            <div class="card-body">
                                <h5 class="card-title">${book.title}</h5>
                                <p class="card-text">Prezzo: ${book.price} €</p>
                                <div class="buttons">
                                <i class="btn btn-danger delete-btn bi bi-trash"></i>
                                </div>
                            </div>
                        </div>
                    `;

                    booksContainer.appendChild(card);
                });

                let deleteButtons = document.querySelectorAll('.delete-btn');
                deleteButtons.forEach(btn => {
                    btn.addEventListener('click', function() {
                        let card = this.closest('.col');
                        card.classList.add('d-none')
                    });
                });
            })
            
