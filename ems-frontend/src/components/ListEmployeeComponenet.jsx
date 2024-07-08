import React, { useEffect } from 'react'
import { useState } from 'react'
import { listEmployees , deleteEmployee } from '../services/EmployeeService';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


const ListEmployeeComponenet = () => {

    // const dummyData =[
    //     {
    //         "id":1,
    //         "firstName": "om",
    //         "lastName":"Mistry",
    //         "email": "o@gmail.com"
    //     },
    //     {
    //         "id":2,
    //         "firstName": "janu",
    //         "lastName":"Mistry",
    //         "email": "o@gmail.com"
    //     },
    //     {
    //         "id":3,
    //         "firstName": "jan",
    //         "lastName":"Mistry",
    //         "email": "o@gmail.com"
    //     }
    // ] 

    const [employees, setEmployees] = useState([]);

    const navigator = useNavigate();

    useEffect(() => {

        //First way to fetch data from database in this create another file EmployeeService.js to fetch data

        // listEmployees().then((response) => {
        //     setEmployees(response.data);
        //     console.log(response.data);
        // }).catch(error => {
        //     console.log(error);
        // })

        //Second Way to fetch data from database

        // axios.get("http://localhost:8080/api/employees").then((response) => {
        //     setEmployees(response.data);
        //     console.log(response.data);
        // }).catch(error => {
        //     console.log(error);
        // })
        getAllEmployees();
    }, [])

    function getAllEmployees(){
        listEmployees().then((response) => {
            setEmployees(response.data);
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }


    function addNeewEmployee() {
        navigator('/add-employee')

    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`);
    }

    function removeEmployee(id){
        console.log(id);

        deleteEmployee(id).then((response)=>{
            getAllEmployees();
        }).catch(error=>{
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>List of Employee</h2>
            <button className='btn btn-primary mb-4' onClick={addNeewEmployee}>Add Employee</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(employee =>
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>
                                    <button className='btn btn-info ' onClick={() => updateEmployee(employee.id)}>Update</button>
                                    <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}
                                    style={{marginLeft: "10px"}} >
                                    Delete</button>

                                </td>
                            </tr>
                        )
                    }

                </tbody>
            </table>

        </div >
    )
}

export default ListEmployeeComponenet
