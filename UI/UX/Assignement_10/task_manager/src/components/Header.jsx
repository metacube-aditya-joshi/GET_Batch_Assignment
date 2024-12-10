import React, { useState } from 'react'
import '../styles/Header.css'
import Task from '../models/task'; // Import the Task model
import TaskModal from './TaskModel'; 
export default function Header({tasks,setTasks}) { // Remove tasks prop as its managed in the component

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [currentTask, setCurrentTask] = useState(null);

  const addTask = (title, description, priority) => {
    const newTask = new Task(title, description, priority);
    console.log(newTask);
    setTasks([...tasks, newTask]); // Use setLocalTasks
    setIsModalOpen(false);
  };

 
  return (
   <div className='header-container'>
    <div className="Header">
    <div > My Task Manager</div>
    <button onClick={() => setIsModalOpen(true)}>Add Task</button>
    {isModalOpen && (
        <TaskModal onClose={() => setIsModalOpen(false)} onAdd={addTask} />
      )}
    </div>
    </div>
  )
}
