// TaskList.jsx
import React from "react";
import Task from "./Task";

export default function TaskList({ tasks, onDelete }) {
  const renderTasks = (status) => {
    return tasks
      .filter(task => task.status === status)
      .map(task => (
        <Task key={task.creationDate} task={task} onDelete={onDelete} />
      ));
  };

  return (
    <div className="task-list">
      <div className="task-list-heading">
        <div className="section new">New</div>
        <div className="section in-progress">In Progress</div>
        <div className="section completed">Completed</div>
      </div>
      <div className="task-list-items">
        <div className="section new-tasks">
          {renderTasks('New')}
        </div>
        <div className="section in-progress-tasks">
          {renderTasks('In Progress')}
        </div>
        <div className="section completed-tasks">
          {renderTasks('Completed')}
        </div>
      </div>
    </div>
  );
}
