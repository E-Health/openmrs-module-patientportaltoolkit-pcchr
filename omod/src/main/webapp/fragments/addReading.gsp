<h1> Add Readings for Patient ID: ${ patient.id }</h1>
<hr>
<script>

function hl10Post(hl10Value, hl10Name, hl10Code){
        var patientid = ${ patient.id };
        var _hl10Value = parseFloat(hl10Value);
        var dataType = 'N'; //Number data
        var dataName = hl10Name;
        var dataCode = hl10Code;
        var dataNs = 'SNOMED - CT';
        jQuery.post('${ ui.actionLink("saveHl10") }', 
            { returnFormat: 'json', 
            patientId: patientid, 
            dataType: dataType,
            dataName: dataName,
            dataCode: dataCode,
            dataNs: dataNs,
            numData: _hl10Value,
            dataUnitNs: dataNs
            },
                function(data) {
                    jQuery("#responds").empty();
                    jQuery("#responds").append("Value Added");
                })
                .error(function() {
                    response = "Error Saving data";
                    jQuery("#responds").empty();
                    jQuery("#responds").append(response);
        })
}

jQuery(document).ready(function() {
 
    //##### Add record when Add Record Button is clicked #########
    jQuery("#GlucoseSave").click(function (e) {
        e.preventDefault();
        hl10Post(jQuery("#glucose").val(),'Blood Sugar', '144194009');

    });

    //##### Add record when Add Record Button is clicked #########
    jQuery("#WeightSave").click(function (e) {
        e.preventDefault();
        hl10Post(jQuery("#weight").val(),'Body Weight', '27113001');


    });

});

</script>
<div id="bit-main">

    <div class="input-group">
        <input id="glucose" type="text" class="form-control" placeholder="Your Blood Glucose Reading" aria-describedby="basic-addon2">
        <span class="input-group-addon" id="basic-addon2">mg/DL</span>
        <button type="button" class="btn btn-success pull-right" id="GlucoseSave">Save Blood Glucose</button>
    </div>
<hr>
    <div class="input-group">
        <input id="weight" type="text" class="form-control" placeholder="Your Weight" aria-describedby="basic-addon2">
        <span class="input-group-addon" id="basic-addon3">Kg</span>
        <button type="button" class="btn btn-success pull-right" id="WeightSave">Save Body Weight</button>
    </div>
    <div id="responds"></div>

</div>

