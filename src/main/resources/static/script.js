const BASE_URL = "http://localhost:8080/api/transactions";
const tableBody = document.querySelector("#transactionTable tbody");
const alertBox = document.getElementById("alertBox");

function showAlert(message, type = "success") {
  alertBox.textContent = message;
  alertBox.className = type;
  alertBox.classList.remove("hidden");
  setTimeout(() => alertBox.classList.add("hidden"), 3000);
}

document.getElementById("loadTransactions").addEventListener("click", async () => {
  try {
    const res = await fetch(BASE_URL);
    if (!res.ok) throw new Error("Network error");
    const data = await res.json();
    tableBody.innerHTML = "";
    data.forEach(txn => {
      const row = `
        <tr>
          <td>${txn.id}</td>
          <td>${txn.transactionId}</td>
          <td>${txn.amount}</td>
          <td>${txn.date}</td>
          <td>${txn.time}</td>
          <td>${txn.currency}</td>
          <td>${txn.customerName}</td>
        </tr>`;
      tableBody.innerHTML += row;
    });
    showAlert("✅ Transactions Loaded!", "success");
  } catch (error) {
    showAlert("❌ Failed to fetch data", "error");
  }
});
