        <%@ include file="common/header.jspf" %>
        <%@ include file="common/navigation.jspf" %>
           <div class="container">
                <h2>Your todos are</h2>
                <table class="table">    
                    <thead>
                        <tr>
                        <th>id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Target date</th>
                        <th>isDone</th>
                        <th></th>
                        <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${todos}" var="todo">
                        <tr>  
                                <td>${todo.id}</td>
                                <td>${todo.userName}</td>
                                <td>${todo.description}</td>
                                <td>${todo.targetDate}</td>
                                <td>${todo.isDone}</td>
                                <td><a href="delete-todos?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
                                <td><a href="update-todos?id=${todo.id}" class="btn btn-primary">UPDATE</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>       
                </table>
                <a href="add-todos"   class="btn btn-success">Add a Todo  </a>
           </div>
           <%@ include file="common/footer.jspf" %>