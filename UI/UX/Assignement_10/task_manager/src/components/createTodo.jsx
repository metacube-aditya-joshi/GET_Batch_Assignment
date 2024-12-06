import React, { useState } from "react";

export default function createTodo() {
    function generateTodos(){

    }
    const [title ,setTitle]=new useState("");
    const [description ,setDescription]=new useState(NEW);
    const [title ,setTitle]=new useState("");
  return (
    <InputRow widthRatios={[1, null]}>
      <TextInput placeholder="Enter Title" value={title} onChange={setTitle(title)} />
      <TextInput placeholder="Enter Description" value={description} onChange={setDescription(description)} />
    </InputRow>
  );
}
