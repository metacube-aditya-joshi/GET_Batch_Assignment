// Task.jsx
import React from "react";

export default function Task({ task, onDelete }) {
  const getPriorityColor = (priority) => {
    switch (priority) {
      case 'High':
        return 'red';
      case 'Medium':
        return 'orange';
      case 'Low':
        return 'green';
      default:
        return 'black';
    }
  };

  return (
    <div style={{ border: `2px solid ${getPriorityColor(task.priority)}` }}>
      <h3>{task.title}</h3>
      <p>{task.description}</p>
      <p>Status: {task.status}</p>
      <p>Created: {task.creationDate}</p>
      {task.completionDate && <p>Completed: {task.completionDate}</p>}
      <button onClick={() => onDelete(task)}>Delete</button>
    </div>
  );
}
