<h1> See Readings </h1>
<hr>
<script>


jQuery(document).ready(function() {

    //##### Delete record when Delete Button is clicked #########
jQuery(".btn-delete").click(function (e) {
/*
    e.preventDefault();
    var hl10Id = jQuery(this).attr("value");
    jQuery.post('${ ui.actionLink("purgeHl10") }',
            { returnFormat: 'json',
                id: hl10Id
            },
            function(data) {
                jQuery("#responds").empty();
                jQuery("#responds").append("Value Deleted");
            })
            .error(function() {
                response = "Error Saving data";
                jQuery("#responds").empty();
                jQuery("#responds").append(response);
            })


        e.preventDefault();
        jQuery.getJSON('${ ui.actionLink("getAllHl10", [returnFormat: "json"]) }', { patientId: ${ patient.id } },

                function(data) {
                    response = data.message;
                    
                    alert(data);
                    
                });
*/
});


});  //JQuery Document Ready

</script>
<div ng-controller="getHl10">
<%
def props = config.properties ?: ["id", "dataName", "dataCode", "dataType", "charData", "numData", "boolData", "dateTimeData"]
%>
<table>
<tr>
<% props.each { %>
    <th>${ ui.message("Pcchr." + it) }</th>
        <% } %>
    </tr>
    <% if (pcchrs) { %>
        <% pcchrs.each { enc -> %>
            <tr>
            <% props.each { prop -> %>
                <td><%= ui.format(enc."${prop}") %></td>
                <% } %>
                <td>
                    <button ng-click="getPcchr('${ patient.id }')" type="button" class="btn btn-delete" value="${ enc.id }">Delete</button>
                </td>
                </tr>
                <% } %>
            <% } else { %>
            <tr>
            <td colspan="4">${ ui.message("general.none") }</td>
        </tr>
            <% } %>
        </table>

<div id="responds"></div>
</div>