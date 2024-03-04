//ESERCIZIO 1

class User{
    constructor(name, surname, _age, _location){
        this.firstName = name;
        this.lastName = surname;
        this.age = _age;
        this.location = _location;
    }
    static ageCompare(user1, user2){
        if (user1.age > user2.age) return `${user1.firstName} ${user1.lastName} è più vecchio di ${user2.firstName} ${user2.lastName}.`
        else if (user1.age < user2.age) return `${user2.firstName} ${user2.lastName} è più vecchio di ${user1.firstName} ${user1.lastName}.`
        else return `${user1.firstName} ${user1.lastName} e ${user2.firstName} ${user2.lastName} hanno la stessa età.`
    }
}

const user1 = new User("Mario","Rossi",28,"Ladispoli");
const user2 = new User("Giancarlo","Bianchi",35,"Civitavecchia");

console.log(User.ageCompare(user1,user2));



//ESERCIZIO 2

let pets = [];

class Pet {
  constructor(petName, ownerName, species, breed) {
    this.petName = petName;
    this.ownerName = ownerName;
    this.species = species;
    this.breed = breed;
  }

  static addPet() {
    const petName = document.getElementById('pet-name').value;
    const ownerName = document.getElementById('pet-owner').value;
    const species = document.getElementById('species').value;
    const breed = document.getElementById('breed').value;

    if (petName && ownerName && species && breed) {
      const newPet = new Pet(petName, ownerName, species, breed);
      pets.push(newPet); 
      Pet.displayPet(newPet);
    }
  }

  static displayPet(pet) {
    const petList = document.getElementById('pet-list');
    const list = document.createElement('ul');
    const nameItem = document.createElement('lh');
    nameItem.textContent = pet.petName;
    const ownerItem = document.createElement('li');
    ownerItem.textContent = `Proprietario: ${pet.ownerName}`;
    const speciesItem = document.createElement('li');
    speciesItem.textContent = `Specie: ${pet.species}`;
    const breedItem = document.createElement('li');
    breedItem.textContent = `Razza: ${pet.breed}`;
  
    list.appendChild(nameItem);
    list.appendChild(ownerItem);
    list.appendChild(speciesItem);
    list.appendChild(breedItem);
  
    petList.appendChild(list);

    if (pets.length > 1) {
      for (let i = 0; i < pets.length - 1; i++) {
        if (Pet.sameOwnerAs(pet, pets[i])) {
          alert(`${pet.petName} e ${pets[i].petName} hanno lo stesso proprietario!`);
          break;
        }
      }
    }
  }

  static sameOwnerAs(pet1, pet2) {
    return pet1.ownerName === pet2.ownerName;
  }
}

document.getElementById('add-pet-btn').addEventListener('click', function() {
    Pet.addPet();
  });