
<link rel="stylesheet"
href="${ ui.resourceLink("patientportaltoolkit", "/styles/HealthGraph.css") }" type="text/css">
<script type="text/javascript"
src="${ ui.resourceLink("patientportaltoolkit", "/scripts/HealthGraph.js") }"></script>
<script type="text/javascript"
src="${ ui.resourceLink("patientportaltoolkit", "/scripts/hammer.js") }"></script>


<script>
        (function () {
            var gender = 'male'
            jQuery(document).ready(function (){
                jQuery.ajax({
                    method: 'get',
                    beforeSend: function(xhr){  var token = jQuery("meta[name='csrf-token']").attr("content");
                        xhr.setRequestHeader("X-CSRF-Token", token);},
                    url: '/openmrs/ms/uiframework/resource/patientportaltoolkit/data/metrics.json',
                    dataType: 'json',
                    async: true,
                    complete: function(jqXHR) {
                        console.log('fillData complete, jqXHR readyState is ' + jqXHR.readyState);

                        if(jqXHR.readyState === 4) {

                            console.log('jqXHR readyState = 4');

                            if(jqXHR.status == 200){
                                var randomBetween = function (min, max) {
                                    if (min < 0) {
                                        return min + Math.random() * (Math.abs(min)+max);
                                    }else {
                                        return min + Math.random() * max;
                                    }
                                };
                                var str = jqXHR.responseText; //metrics json
                                console.log('str = ' + str);
                                var json = jQuery.parseJSON(str);
                                var factors_array = [];
                                var factor_json;
                                var cholesterol = {
                                    label   : 'Total Cholesterol',
                                    score   : 0,
                                    value : 0,
                                    actual: 0,
                                    weight: 0,
                                    details : []
                                }
                                var bp = {
                                    label   : 'Blood Pressure',
                                    score   : 0,
                                    value : 0,
                                    actual: 0,
                                    weight: 0,
                                    details : []
                                }
                                if (json[0].gender === gender)
                                    factor_json = json[0].metrics;
                                else
                                    factor_json = json[1].metrics;

                                console.log(factor_json);
                                for (var i = 0; i < factor_json.length; i++) {
                                    var random = randomBetween(factor_json[i].features.totalrange[0], factor_json[i].features.totalrange[1]);
                                    console.log(factor_json[i].name);
                                    console.log(factor_json[i].features);
                                    console.log(random);
                                    if ((factor_json[i].name === 'LDL' || factor_json[i].name === 'HDL' || factor_json[i].name === 'Triglycerides') && cholesterol != null)
                                    {
                                        cholesterol.details.push({
                                            label: factor_json[i].name,
                                            score: HGraph.prototype.calculateScoreFromValue(factor_json[i].features, random),
                                            value: parseFloat(random).toFixed(2) +  ' ' +  factor_json[i].features.unitlabel,
                                            actual: random,
                                            weight: factor_json[i].features.weight
                                        });
                                        if (cholesterol.details.length >= 3) {
                                            for(var j = 0; j < cholesterol.details.length; j++) {
                                                cholesterol.score = cholesterol.score + cholesterol.details[j].score
                                                cholesterol.actual = cholesterol.actual + cholesterol.details[j].actual
                                                cholesterol.weight = cholesterol.weight + cholesterol.details[j].weight
                                            }
                                            cholesterol.score /= 3;
                                            cholesterol.weight /= 3;
                                            cholesterol.value = parseFloat(cholesterol.actual).toFixed(2)  +  ' ' + factor_json[i].features.unitlabel;
                                            factors_array.push(cholesterol);
                                            cholesterol = null
                                        }


                                    } else if ((factor_json[i].name === 'Blood Pressure Diastolic' || factor_json[i].name === 'Blood Pressure Systolic') && bp != null)
                                    {
                                        bp.details.push({
                                            label: factor_json[i].name.replace('Blood Pressure ', ''),
                                            score: HGraph.prototype.calculateScoreFromValue(factor_json[i].features, random),
                                            value: parseFloat(random).toFixed(2) +  ' ' +  factor_json[i].features.unitlabel,
                                            weight: factor_json[i].features.weight,
                                            actual: random
                                        });
                                        if (bp.details.length >= 2) {
                                            console.log(bp.score);
                                            for(var j = 0; j < bp.details.length; j++) {
                                                bp.score = bp.score + bp.details[j].score;
                                                bp.weight = bp.weight + bp.details[j].weight;
                                            }
                                            bp.score /= 2;
                                            bp.weight /= 2;
                                            bp.value = parseFloat(bp.details[0].actual).toFixed(2)  +  '/' + parseFloat(bp.details[1].actual).toFixed(2) + ' ' + factor_json[i].features.unitlabel;
                                            factors_array.push(bp);
                                            bp = null
                                        }


                                    }
                                    else
                                        factors_array.push(
                                                {
                                                    label: factor_json[i].name,
                                                    score: HGraph.prototype.calculateScoreFromValue(factor_json[i].features, random),
                                                    value: parseFloat(random).toFixed(2) +  ' ' +  factor_json[i].features.unitlabel,
                                                    weight: factor_json[i].features.weight
                                                }
                                        )
                                }
                                var opts = {
                                    container: document.getElementById("viz"),
                                    userdata: {
                                        hoverevents : true,
                                        factors: factors_array
                                    },
                                    showLabels : true
                                };
                                console.log(opts);
                                graph = new HGraph(opts);
                                graph.width = 760;
                                graph.height = 602;
                                graph.initialize();


                            }
                        }
                    }

                });
            });
        })();
</script>

<section id="main">
<section id="graph_container" class="content_inset">
<figure id="viz" class="content_inset healthgraph detailed">
</figure>
		</section>
</section>
                            <h2>${ person.gender }</h2>


    <% if (pcchrs) { %>
<h2>Yes: ${ pcchrs["Body Weight"] }</h2>
            <% } %>


                    <div id="responds"></div>
</div>