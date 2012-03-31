<%@tag description="task box" pageEncoding="UTF-8"%>

<%@attribute name="task" required="true" type="hackaton.rest.TaskOverview" %>

<div class="full-progress">
            <div class="progress" style="width: ${task.progress}}%">           
                <div class="task">
                    <div class="content">
                        <div class="state">${task.state}</div>
                        <div class="head">
                            <h2><a href="${task.url}" title="${task.title}">${task.title}</a></h2>
                            <div class="type" />${task.type}</div>
                    </div>
                    <div class="description">
                        ${task.description}
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