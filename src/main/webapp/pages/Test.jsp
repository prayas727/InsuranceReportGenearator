<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insurance Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<form:form action="/save" method="POST" modelAttribute="searchBean">
      <table>
          <tr>
              <td>Plan Name:</td>
              <td><form:input path="splanName" type="text"/></td>
          </tr>
          <tr>
              <td>Plan Status:</td>
              <td><form:input path="splanStatus" /></td>
          </tr>
               <tr>
              <td>Plan StartDate:</td>
              <td><form:input path="splanStartDate" type="date"/></td>
          </tr>
          <tr>
              <td>Plan EndDate:</td>
              <td><form:input path="splanEndDate"  type="date" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Search"  class="btn btn-primary" />
              </td>
                <td colspan="2">
              <input type="submit" value="Export Excel file" name="export" class="btn btn-primary" />
              </td> 
                <td colspan="2">
              <input type="submit" value="Export Pdf file" name="export" class="btn btn-primary" />
              </td>
          </tr>
      </table>
  </form:form>
<hr>
<table class="table table-info">
<thead>
<tr>
<th>Id</th>
<th>Holder Name</th>
<th>Gender</th>
<th>Plan Name</th>
<th>Plan Status</th>
<th>Plan Start Date</th>
<th>Plan End Date</th>
<th>BenefitAmt</th>
<th>Denial Reason</th>
</tr>
</thead>
<tbody>
<c:forEach items="${plans}" var="plan">
<tr>
<td>${plan.citizenId}</td>
<td>${plan.citizenName}</td>
<td>${plan.gender}</td>
<td>${plan.planName}</td>
<td>${plan.planStatus}</td>
<td>${plan.planStartDate}</td>
<td>${plan.planEndDate}</td>
<td>${plan.benefitAmt}</td>
<td>${plan.denialReason}</td>

</tr>

</c:forEach>
</tbody>
</table>
</hr>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>