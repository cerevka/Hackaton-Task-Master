<%@tag description="task box" pageEncoding="UTF-8"%>

<%@attribute name="state" required="true" type="java.lang.String" %>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="type" required="true" type="java.lang.String" %>
<%@attribute name="url" required="true" type="java.lang.String" %>
<%@attribute name="progress" required="true" type="java.lang.String" %>

<div class="full-progress">
            <div class="progress" style="width: ${progress}}%">           
                <div class="task">
                    <div class="content">
                        <div class="state">${state}</div>
                        <div class="head">
                            <h2><a href="{$url}" title="${title}">${title}</a></h2>
                            <div class="type" />${type}</div>
                    </div>
                    <div class="description">
                        <jsp:doBody />
                    </div>
                    <div class="tags">
                        <div class="tag"><a href="#" title="Java">Java</a></div>
                        <div class="tag"><a href="#" title="DB">DB</a></div>
                        <div class="tag"><a href="#" title="těžké">těžké</a></div>
                        <div class="tag"><a href="#" title="GAE">GAE</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>