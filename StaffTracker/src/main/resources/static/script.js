window.onload = function () {
  fetch("/staff/full")
    .then(function (response) {
      return response.json();
    })
    .then(function (staffList) {
      const container = document.getElementById("staffContainer");

      staffList.forEach(function (staff) {
        const card = document.createElement("div");
        card.className = "staff-card";
        card.setAttribute("data-department", staff.departmentName);
        card.setAttribute(
          "data-name",
          staff.staffForename + " " + staff.staffSurname,
        );
        card.setAttribute(
          "data-id",
          "S" + String(staff.staffID).padStart(3, "0"),
        );
        card.innerHTML =
          "<h2>" +
          staff.staffForename +
          " " +
          staff.staffSurname +
          "</h2>" +
          "<p>ID: S" +
          String(staff.staffID).padStart(3, "0") +
          "</p>" +
          "<p>Job: " +
          staff.jobTitle +
          "</p>" +
          "<p>Department: " +
          staff.departmentName +
          "</p>" +
          "<p>Manager: " +
          staff.lineManager +
          "</p>" +
          "<p>Status: " +
          staff.status +
          "</p>" +
          "<button class='icon-btn'><img src='img/icons8-edit-96.png' class='edit-icon'></button>" +
          "<button class='icon-btn'><img src='img/icons8-flag-96.png' class='flag-icon'></button>" +
          "<button onclick='deleteStaff(" +
          staff.staffID +
          ', "' +
          staff.staffForename +
          '", "' +
          staff.staffSurname +
          "\")'><img src='img/icons8-trash.svg' class='bin-icon'></button>";
        container.appendChild(card);
      });
    });
  loadDropdowns();
};

function deleteStaff(id, forename, surname) {
  const confirmed = confirm(
    "Are you sure you want to delete " + forename + " " + surname + "?",
  );
  if (confirmed) {
    fetch("/staff/" + id, { method: "DELETE" }).then(function () {
      location.reload();
    });
  }
}

function addStaff() {
  const newStaff = {
    staffForename: document.getElementById("forename").value,
    staffSurname: document.getElementById("surname").value,
    jobTitle: document.getElementById("jobTitle").value,
    status: document.getElementById("status").value,
    departmentID: document.getElementById("departmentID").value,
    managerID: document.getElementById("managerID").value,
  };

  fetch("/staff", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(newStaff),
  }).then(function () {
    location.reload();
  });
}

function loadDropdowns() {
  fetch("/departments")
    .then(function (response) {
      return response.json();
    })
    .then(function (departments) {
      const select = document.getElementById("departmentID");
      const filterSelect = document.getElementById("departmentFilter");
      departments.forEach(function (dept) {
        const option = document.createElement("option");
        option.value = dept.departmentID;
        option.textContent = dept.departmentName;
        select.appendChild(option);

        const filterOption = document.createElement("option");
        filterOption.value = dept.departmentName;
        filterOption.textContent = dept.departmentName;
        filterSelect.appendChild(filterOption);
      });
    });

  fetch("/managers")
    .then(function (response) {
      return response.json();
    })
    .then(function (managers) {
      const select = document.getElementById("managerID");
      managers.forEach(function (mgr) {
        const option = document.createElement("option");
        option.value = mgr.managerID;
        option.textContent = mgr.managerForename + " " + mgr.managerSurname;
        select.appendChild(option);
      });
    });
}

function showForm() {
  document.getElementById("overlay-backdrop").style.display = "flex";
}

function hideForm() {
  document.getElementById("overlay-backdrop").style.display = "none";
}

function filterStaff() {
  const chosen = document.getElementById("departmentFilter").value;
  const cards = document.querySelectorAll(".staff-card");

  cards.forEach(function (card) {
    const dept = card.getAttribute("data-department");

    if (chosen === "" || dept === chosen) {
      card.style.display = "block";
    } else {
      card.style.display = "none";
    }
  });
}

function showSearch() {
  document.getElementById("search-backdrop").style.display = "flex";
}

function hideSearch() {
  document.getElementById("search-backdrop").style.display = "none";
}

function searchStaff() {
  const idTerm = document.getElementById("searchID").value.toLowerCase().trim();
  const nameTerm = document
    .getElementById("searchName")
    .value.toLowerCase()
    .trim();
  const cards = document.querySelectorAll(".staff-card");

  cards.forEach(function (card) {
    const name = card.getAttribute("data-name").toLowerCase();
    const id = card.getAttribute("data-id").toLowerCase();

    let matches = true;

    if (idTerm !== "" && id !== idTerm) {
      matches = false;
    }
    if (nameTerm !== "" && !name.includes(nameTerm)) {
      matches = false;
    }

    if (matches) {
      card.style.display = "block";
    } else {
      card.style.display = "none";
    }
  });

  hideSearch();
}

function resetView() {
  const cards = document.querySelectorAll(".staff-card");
  cards.forEach(function (card) {
    card.style.display = "block";
  });
  document.getElementById("departmentFilter").value = "";
  document.getElementById("searchID").value = "";
  document.getElementById("searchName").value = "";
}

function toggleMenu() {
  document.getElementById("sideMenu").classList.toggle("open");
  document.getElementById("menuBackdrop").classList.toggle("open");
}
