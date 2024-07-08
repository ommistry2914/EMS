
import './App.css'
import EmployeeComponenet from './components/EmployeeComponenet'
import ListEmployeeComponenet from './components/ListEmployeeComponenet'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={ <ListEmployeeComponenet/>}></Route>
          <Route path='/employees' element={ <ListEmployeeComponenet/>}></Route>
          <Route path='/add-employee' element={<EmployeeComponenet/>}></Route>
          <Route path='/edit-employee/:id' element={<EmployeeComponenet/>}></Route>

        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
