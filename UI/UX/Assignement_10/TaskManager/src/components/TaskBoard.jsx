import React, { useState, useEffect } from "react";
import TaskModal from "./TaskModal";
import TaskCard from "./TaskCard";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";

const TaskBoard = () => {
   // Retrieve existing tasks from localStorage
   const storedTasks = localStorage.getItem("tasks");
   console.log(storedTasks)
   const existingTasks = storedTasks ? JSON.parse(storedTasks) : []; // Check if storedTasks is not null
   console.log(existingTasks);
   const [tasks, setTasks] = useState(existingTasks);

   // Optional: useEffect to sync tasks with localStorage whenever they change
   useEffect(() => {
       localStorage.setItem("tasks", JSON.stringify(tasks));
   }, [tasks]);

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [currentTask, setCurrentTask] = useState(null);

  const handleSaveTask = (newTask) => {
    if (currentTask) {
      setTasks((prev) =>
        prev.map((task) => (task.id === currentTask.id ? newTask : task))
      );
    } else {
      setTasks((prev) => [
        ...prev,
        { ...newTask, id: Date.now(), status: "New" },
      ]);
    }
    setCurrentTask(null);
  };

  const handleDeleteTask = (id) => {
    setTasks((prev) => prev.filter((task) => task.id !== id));
  };

  const handleDragEnd = (result) => {
    if (!result.destination) return;

    const updatedTasks = Array.from(tasks);
    const [movedTask] = updatedTasks.splice(result.source.index, 1);
    movedTask.status = result.destination.droppableId;
    updatedTasks.splice(result.destination.index, 0, movedTask);
    setTasks(updatedTasks);
  };

  const lanes = ["New", "In Progress", "Completed"];
  return (
    <div>
      <header className="flex justify-between p-4 bg-blue-500 text-white">
        <h1>My Task Tracker</h1>
        <button
          onClick={() => setIsModalOpen(true)}
          className="bg-green-500 px-4 py-2 rounded"
        >
          New Task
        </button>
      </header>
      <DragDropContext onDragEnd={handleDragEnd}>
        <div className="flex gap-4 p-4">
          {lanes.map((lane) => (
            <Droppable droppableId={lane} key={lane}>
              {(provided) => (
                <div
                  ref={provided.innerRef}
                  {...provided.droppableProps}
                  className="flex-1 bg-gray-100 p-4 rounded shadow-md"
                >
                  <h2 className="text-xl font-bold mb-4">{lane}</h2>
                  {localStorage.setItem("tasks", JSON.stringify(tasks))}
                  {tasks
                    .filter((task) => task.status === lane)
                    .map((task, index) => (
                      <Draggable
                        key={task.id}
                        draggableId={task.id.toString()}
                        index={index}
                      >
                        {(provided) => (
                          <div
                            ref={provided.innerRef}
                            {...provided.draggableProps}
                            {...provided.dragHandleProps}
                          >
                            <TaskCard
                              task={task}
                              onDelete={() => handleDeleteTask(task.id)}
                              onEdit={() => {
                                setCurrentTask(task);
                                setIsModalOpen(true);
                              }}
                            />
                          </div>
                        )}
                      </Draggable>
                    ))}
                  {provided.placeholder}
                </div>
              )}
            </Droppable>
          ))}
        </div>
      </DragDropContext>
      <TaskModal
        isOpen={isModalOpen}
        onClose={() => {
          setIsModalOpen(false);
          setCurrentTask(null);
        }}
        onSave={handleSaveTask}
        task={currentTask}
      />
    </div>
  );
};

export default TaskBoard;
