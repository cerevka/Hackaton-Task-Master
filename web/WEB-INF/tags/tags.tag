<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="tags" required="true" type="java.util.List" %>
<c:forEach items="${tags}" var="tag">
    <div>
        <form action="tag" method="POST">
            <spna>${tag.text}</spna>
            <input type="hidden" name="id" value="${tag.id}" />
            <input type="hidden" name="color" class="colorpicker" size="6" value="${tag.color}" />
        </form>
    </div>
    <br />
</c:forEach>
    <div>
        <form action="tag" method="POST">
            <spna><input type="text" name="text" /></spna>
            <input type="hidden" name="color" class="colorpicker-new" size="6" value="${tag.color}" />
            <input type="submit" value="Submit" title="Submit" />
        </form>
    </div>

<script type="text/javascript">
    $(".colorpicker").miniColors({
        letterCase: 'uppercase',
        change: function(hex, rgb) {
           $(this).parent().submit();
        }
    });
    
    $(".colorpicker-new").miniColors({
        letterCase: 'uppercase'
    });
</script>