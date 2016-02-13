<html>
<head>
<title>OpenMRS Patient Portal</title>
<link rel="shortcut icon" type="image/ico"
	href="/openmrs/images/openmrs-favicon.ico">
<link rel="icon" type="image/png\"
	href="/openmrs/images/openmrs-favicon.png">
<script type="text/javascript"
	src="${ ui.resourceLink("patientportaltoolkit", "/scripts/jquery-1.11.1.min.js") }"></script>
<script type="text/javascript"
	src="${ ui.resourceLink("uicommons", "/scripts/jquery-ui-1.9.2.custom.min.js")}"></script>
<script type="text/javascript"
	src="${ ui.resourceLink("uicommons", "/scripts/underscore-min.js")}"></script>

<script type="text/javascript"
    src="${ ui.resourceLink("uicommons", "/scripts/angular.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("uicommons", "/scripts/angular-resource.min.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("uicommons", "/scripts/ngDialog/ngDialog.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/app.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/controllers.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/services.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/xeditable.min.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/angular-dragdrop.min.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/react.min.js")}"></script>
<script type="text/javascript"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/react-dom.min.js")}"></script>
<script type="text/babel"
    src="${ ui.resourceLink("patientportaltoolkit", "/scripts/react-code.js")}"></script>
<link rel="stylesheet"
    href="${ ui.resourceLink("uicommons", "styles/ngDialog/ngDialog.min.css") }"
    type="text/css">
<link rel="stylesheet"
          href="${ ui.resourceLink("patientportaltoolkit", "styles/xeditable.css") }"
          type="text/css">





<script type="text/javascript"
	src="${ ui.resourceLink("uicommons", "/scripts/jquery.toastmessage.js")}"></script>
<script type="text/javascript"
	src="${ ui.resourceLink("uicommons", "/scripts/jquery.simplemodal.1.4.4.min.js")}"></script>
<script type="text/javascript"
	src="${ ui.resourceLink("patientportaltoolkit", "/scripts/bootstrap.min.js") }"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="${ ui.resourceLink("patientportaltoolkit", "styles/bootstrap.min.css") }"
	type="text/css">
    <link rel="stylesheet"
          href="${ ui.resourceLink("patientportaltoolkit", "styles/datepicker.css") }"
          type="text/css">
    <link rel="stylesheet"
          href="${ ui.resourceLink("patientportaltoolkit", "styles/styles.css") }"
          type="text/css">
    <script type="text/javascript"
            src="${ ui.resourceLink("patientportaltoolkit", "/scripts/patientPortalScripts.js")}"></script>

    <script type="text/javascript"
            src="${ ui.resourceLink("patientportaltoolkit", "/scripts/bootstrap-datepicker.js") }"></script>

    <script type="text/javascript"
            src="${ ui.resourceLink("patientportaltoolkit", "/scripts/d3.min.js") }"></script>

</head>
<body ng-app="pcchr">
<div class="navbar navbar-default container">
    <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target=".navbar-responsive-collapse">
        <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
    </button>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li id="patientPortalJournals"><a href="journals.page">Home</a></li>
            <li id="patientPortalNavHome"><a href="home.page">Profile</a></li>
            <li id="patientPortalConnections"><a href="patientconnections.page">Circle of Care</a></li>
            </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="messages.page"><span class="glyphicon glyphicon-envelope"></span></a></li>
            <li><a id="navigationLogout">Logout <span
                    class="glyphicon glyphicon-log-out"></span></a></li>

        </ul>
    </div>
</div>