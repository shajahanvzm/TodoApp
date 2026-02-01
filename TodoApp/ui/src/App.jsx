import { useEffect, useState } from "react"
import { getTodos,deleteTodo, createTodo } from "./services/TodoService"


function App() {
  const [todos, setTodos] = useState([])
  const initTodo = {
    task: '',
    description: '',
    done: false
  }
  const [todo, setTodo] = useState(initTodo)

  useEffect(()=>{
    loadTodos()
  },[])


  const loadTodos = async() => {
    const res = await getTodos()
    setTodos(res.data)
    setTodo(initTodo)

  }
  const delTodo = async (id) => {
    await deleteTodo(id)
    loadTodos()

  }

  const onChange = (e) => {
    const {name, value} = e.target
    setTodo(prevData => ({...prevData, [name]: value}))
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    await createTodo(todo)
    loadTodos()
  }
  return (
    <>
     <h1>Todo App</h1>
     <div>
        <h3>Add Todo</h3>
        <form onSubmit={onSubmit}>
           <input type="text" name="task" value={todo.task}  onChange={onChange} />
           <br />
           <textarea name="description" value={todo.description} onChange={onChange}></textarea>
           <br />
           <button type="submit">Submit</button>
        </form>
     </div>
     <div>
     <ul>
      {todos.map((todo) => (
          <li key={todo.id}>
            <h3>{todo.task}</h3>
            <p>{todo.description}</p>
            <button onClick={ ()=>delTodo(todo.id) }>Delete </button>
          </li>
        ))
      }
     </ul>
     </div>
    </>
  )
}

export default App
