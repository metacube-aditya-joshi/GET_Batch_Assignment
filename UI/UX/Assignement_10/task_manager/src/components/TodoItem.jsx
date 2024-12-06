import React from "react";
function TodoItem({props}) {
  return (
    <div className="todo-item">
      <div className="todo-priority">
        <div className="todo-title"></div>
        <div className="todo-creation-date"></div>
        <div className="todo-description"></div>
        <div className="todo-completion-date"></div>
      </div>
    </div>
  );
}
export default TodoItem;
