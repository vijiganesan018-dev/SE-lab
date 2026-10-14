<!DOCTYPE html>
<html>
<head>
<title>Hospital Management System</title>
<script>
    var patientCount = 0;
    function addPatient() {
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var disease = document.getElementById("disease").value;
        if (name == "" || age == "" || disease == "") {
            alert("Please fill all fields");
            return false;
        }
        patientCount++;
        document.getElementById("patientCount").innerHTML =
            "Patient Count : " + patientCount;
        return false;
    }
</script>
</head>
<body>
<h2>Hospital Management System</h2>
<form onsubmit="return addPatient();">
    <label>Name</label><br>
    <input type="text" id="name"><br><br>
    <label>Age</label><br>
    <input type="number" id="age"><br><br>
    <label>Disease</label><br>
    <input type="text" id="disease"><br><br>
    <input type="submit" id="submit" value="Submit">
</form>
<h3 id="patientCount">Patient Count : 0</h3>
</body>
</html>
