<h1> See Readings </h1>
<hr>
<script>


</script>

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
            </tr>
                <% } %>
            <% } else { %>
            <tr>
            <td colspan="4">${ ui.message("general.none") }</td>
        </tr>
            <% } %>
        </table>