// Task.js
export default class Task {
    constructor(title, description, priority) {
      this.title = title;
      this.description = description;
      this.status = 'New'; // Default status
      this.creationDate = new Date().toISOString();
      this.completionDate = null;
      this.priority = priority; // 'High', 'Medium', 'Low'
    }
  }
  