// TaskModal.jsx
import React, { useState } from "react";

export default function TaskModal({ onClose, onAdd }) {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [priority, setPriority] = useState("Medium"); // Default priority

  const handleSubmit = (e) => {
    e.preventDefault();
    onAdd(title, description, priority);
    setTitle("");
    setDescription("");
    setPriority("Medium");
  };

  return (
    <div className="modal">
      <h2>Create Task</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Priority:</label>
          <select
            value={priority}
            onChange={(e) => setPriority(e.target.value)}
          >
            <option value="High">High</option>
            <option value="Medium">Medium</option>
            <option value="Low">Low</option>
          </select>
        </div>
        <button type="submit">Add Task</button>
        <button type="button" onClick={onClose}>Cancel</button>
      </form>
    </div>
  );
}
