import React from 'react';

const TaskCard = ({ task, onDelete,onEdit }) => {
    const priorityColors={
        High:"bg-red-200",
        Medium:"bg-yellow-200",
        Low:"bg-green-200"
    };

    return (
        <div
        className={`p-4 rounded-lg shadow-md mb-4 ${priorityColors[task.priority]}`}>
        <h3 className="font-bold">{task.title}</h3>
        <p>{task.description}</p>
        <div className='flex justify-between mt-2'>
            <button onClick={onEdit} className='text blue-500'>Edit</button>
            <button onClick={onDelete} className='text red-500'>Delete</button>
        </div>
        </div>
    );
};

export default TaskCard;
