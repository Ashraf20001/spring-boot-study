        <%@ include file="common/header.jspf" %>
        <%@ include file="common/navigation.jspf"   %>

           <div class="container">
                <h2>Enter New ToDos</h2>
                <form:form method="post" modelAttribute="todo">
                   <fieldset class="mb-3">
                     <form:label path="description">Description :</form:label>
                     <form:input type="text" path="description" required="required"/>
                     <form:errors path="description" cssClass="text-warning"></form:errors>
                   </fieldset>

                   <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date :</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"></form:errors>
                  </fieldset>
                    
                    <input type="submit" class="btn btn-success"> </input>
                </form:form>
                
           </div>
           <%@ include file="common/footer.jspf" %>

           <script type="text/javascript">
            $('#targetDate').datepicker({
                    format: 'dd-mm-yyyy'
                });
            </script>

          