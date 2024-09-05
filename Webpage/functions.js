myFunctions = {
    getCompanyName: function () {
      return "SALT";
    },
    getAlert: function () {
      alert("hi");
    },
    getList: function () {
      //Clears any children
      const element = document.getElementById("List");
      while (element.firstChild) {
        element.removeChild(element.lastChild);
      }

      //Fetches updated list
      fetch("http://localhost:8080/getList")
      .then((response) => response.json())
      .then((data) => {
        const listBackground = document.createElement("div");
        for (i = 0; i < data.length; i++)
        {
        const temp = data[i];
        const upperBarrier = document.createElement("div");
        upperBarrier.textContent = "----------------";
        const adOwner = document.createElement("div");
        const adArea = document.createElement("div");
        adOwner.textContent = `${temp.name}`;
        adArea.textContent = `${temp.adress}`;
        tempDiv = document.createElement("div");
        tempDiv.appendChild(upperBarrier);
        tempDiv.appendChild(adOwner);
        tempDiv.appendChild(adArea);
        listBackground.appendChild(tempDiv);
        }
        element.appendChild(listBackground);
      });

    },
    getUsers: function (element) {
      const name = "Erik";
      fetch("http://localhost:8080/greet?name=" + name)
        .then((response) => response.json())
        .then((data) => {
          const newDiv = document.createElement("div");
          const heading = document.createElement("h2");
          heading.innerText = `${data.content}`;
          newDiv.appendChild(heading);
          element.appendChild(newDiv);
        });
    },
    dummyTest: function () {
      fetch("http://localhost:8080/createAdress")
      .then((response) => response.json())
      .then((data) => console.log({ data }));

    },
    createNewUser: function () {
      var AdressName = prompt("Who lives on the adress?");
      var AdressArea = prompt("Whats his/her adresss?");
      fetch("http://localhost:8080/createAdress?name=" + AdressName +"&area=" + AdressArea)
      .then((response) => response.json())
      .then((data) => console.log({ data }));
      myFunctions.getList();

    },
    sortByName: function () {
      var Name = prompt("What name do you wish to search for?")
      fetch("http://localhost:8080/sortListName?name=" + Name)
      .then((response) => response.json());
      myFunctions.getList();
    }
    
  };
  console.log("salt> Functions loaded");