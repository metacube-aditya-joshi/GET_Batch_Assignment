// App.jsx
import React, { useState } from 'react';
import Header from './components/Header';
import TaskList from './components/TaskList';
import Task from './models/Task'; // Import the Task model
import TaskModal from './components/TaskModal'; // Modal for creating/editing tasks

function App() {
  const [tasks, setTasks] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [currentTask, setCurrentTask] = useState(null);

  const addTask = (title, description, priority) => {
    const newTask = new Task(title, description, priority);
    setTasks([...tasks, newTask]);
    setIsModalOpen(false);
  };

  const deleteTask = (taskToDelete) => {
    setTasks(tasks.filter(task => task !== taskToDelete));
  };

  return (
    <>
      <Header />
      <TaskList tasks={tasks} onDelete={deleteTask} />
      <button onClick={() => setIsModalOpen(true)}>Add Task</button>
      {isModalOpen && (
        <TaskModal onClose={() => setIsModalOpen(false)} onAdd={addTask} />
      )}
    </>
  );
}

export default App;
