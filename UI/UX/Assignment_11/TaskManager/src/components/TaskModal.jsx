import React, { useState, useEffect } from "react";
import Modal from "react-modal";
Modal.setAppElement('#root');

const TaskModal = ({ isOpen, onClose, onSave, task = {} }) => {
  const [title, setTitle] = useState(task ? task.title : "");
  const [description, setDescription] = useState(task ? task.description : "");
  const [priority, setPriority] = useState(task ? task.priority : "Medium");

  useEffect(() => {
      if (task) {
          setTitle(task.title);
          setDescription(task.description);
          setPriority(task.priority);
      } else {
          setTitle('');
          setDescription('');
          setPriority("Medium");
      }
  }, [task]);

  const handleSubmit = () => {
    const newTask = { ...task, title, description, priority };
    console.log(newTask);
    onSave(newTask);
    onClose();
  };
  return (
    <Modal isOpen={isOpen} onRequestClose={onClose} className="modal">
      <h2 className="text-xl font-bold ">Task</h2>
      <input
        type="text"
        className="border p-2 rounded w-full mb-4"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <textarea
        className="border p-2 rounded mb-4 w-full" 
        placeholder="Description"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      ></textarea>
      <select
        className="border p-2 rounded w-full mb-4"
        value={priority}
        onChange={(e) => setPriority(e.target.value)}
      >
        <option value="High">High</option>
        <option value="Medium">Medium</option>
        <option value="Low">Low</option>
      </select>
      <button onClick={handleSubmit} className="bg-blue-500 text-white px-4 me-2 py-2 rounded">Save</button>
      <button onClick={onClose} className="bg-gray-300 text-black px-4 py-2 rounded">Cancel</button>
    </Modal>
  );
};

export default TaskModal;
