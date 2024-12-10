// TaskList.jsx
import React from "react";
import Task from "./Task";
import "../styles/TaskList.css";
export default function TaskList({ tasks, onDelete }) {
  const renderTasks = (status) => {
    return tasks
      .filter((task) => task.status === status)
      .map((task) => (
        <Task key={task.creationDate} task={task} onDelete={onDelete} />
      ));
  };

  return (
    <div className="task-list">
      <div className="task-list-heading">
        <div className="section new">
          <p>New</p>
          <div className="section new-tasks">{renderTasks("New")}</div>
        </div>
        <div className="section in-progress">
          <p>In Progress</p>
          <div className="section in-progress-tasks">
            {renderTasks("In Progress")}
          </div>
        </div>
        <div className="section completed">
          <p>Completed</p>
          <div className="section completed-tasks">
            {renderTasks("Completed")}
          </div>
        </div>
      </div>
    </div>
  );
}
