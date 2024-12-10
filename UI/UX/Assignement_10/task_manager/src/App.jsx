// App.jsx
import React, { useState } from 'react';
import Header from './components/Header';
import TaskList from './components/TaskList';
// Modal for creating/editing tasks

function App() {
  const [tasks, setTasks] = useState([]);
 
  const deleteTask = (taskToDelete) => {
    setTasks(tasks.filter(task => task !== taskToDelete));
  };
  return (
    <>
      <Header tasks={tasks} setTasks={setTasks}/>
      <TaskList tasks={tasks} onDelete={deleteTask} />
     
      
    </>
  );
}

export default App;
