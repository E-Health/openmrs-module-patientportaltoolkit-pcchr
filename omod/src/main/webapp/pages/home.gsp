
${ ui.includeFragment("patientportaltoolkit", "patientPortalNav") }
<script type="text/javascript">
    \$(document).ready(function(){
        \$('#patientPortalNavHome').addClass('active');
    });
</script>
<body>
<div class="container bgcontent col-sm-8 col-sm-offset-2">
    ${ ui.includeFragment("patientportaltoolkit", "profileHeader") }
    <ul class="nav nav-pills">
    <li class="active"><a data-toggle="tab" href="#addReading">Add Readings</a></li>
    <li><a data-toggle="tab" href="#seeReading">See Readings</a></li>
    <li><a data-toggle="tab" href="#seeGraphs">See Graphs</a></li>
    <li><a data-toggle="tab" href="#alerts">Alerts</a></li>
    <li><a data-toggle="tab" href="#hGraph">hGraph</a></li>
    <li><a data-toggle="tab" href="#resources">Resources</a></li>
    </ul>

    <div class="tab-content">
        <div id="addReading" class="tab-pane fade in active">
            ${ ui.includeFragment("patientportaltoolkit", "addReading") }
        </div>
        <div id="seeReading" class="tab-pane fade">
            ${ ui.includeFragment("patientportaltoolkit", "seeReading") }
        </div>
        <div id="seeGraphs" class="tab-pane fade">
            ${ ui.includeFragment("patientportaltoolkit", "seeGraph") }
        </div>
        <div id="alerts" class="tab-pane fade">
            ${ ui.includeFragment("patientportaltoolkit", "alerts") }
        </div>
        <div id="hGraph" class="tab-pane fade">
            ${ ui.includeFragment("patientportaltoolkit", "hGraph") }
        </div>
        <div id="resources" class="tab-pane fade">
            ${ ui.includeFragment("patientportaltoolkit", "tailoredInfo") }
        </div>
    </div>
</div>
</body>