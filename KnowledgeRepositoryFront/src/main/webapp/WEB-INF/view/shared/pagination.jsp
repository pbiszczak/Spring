<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="firstUrl" value="${urlPath}1" />
<c:url var="lastUrl" value="${urlPath}${pageCount}" />
<c:url var="prevUrl" value="${urlPath}${currentIndex - 1}" />
<c:url var="nextUrl" value="${urlPath}${currentIndex + 1}" />

<div>
        <ul class="pagination">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="page-item disabled">
                    <a class="page-link" href="#">&lt;&lt;</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">&lt;</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="${firstUrl}">&lt;&lt;</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="${prevUrl}">&lt;&lt;</a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="page-item active">
                        <a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == pageCount}">
                <li class="page-item disabled">
                    <a class="page-link" href="#">&gt;</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">&gt;&gt;</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="${nextUrl}">&gt;</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="${lastUrl}">&gt;&gt;</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>

</div>