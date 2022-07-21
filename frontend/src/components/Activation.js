import React from "react"

export default function Activation(props) {

    const [activationElements, setActivationElements] = React.useState([])
    const [finalActivationPercentage, setFinalActivationPercentage] = React.useState()

    const handleChange = (id, event) => {
        event.preventDefault()
        let data = [...activationElements]
        data[id][event.target.name] = event.target.value
        setActivationElements(data)
    }

    function createNewActivationElement() {
        return {
            id: activationElements.length,
            name: "",
            percentage: 0.0
        }
    }

    function addActivationElement() {
        const newElement = createNewActivationElement()
        setActivationElements(prevElements => [...prevElements, newElement])
    }

    function deleteElement(id) {
        setActivationElements(prev => prev.filter(element => element.id !== id))
    }


    const activationInputs = activationElements.map(element => <li key={element.id}>
        <input type="text" name="name" placeholder="name" value={element.name} onChange={(event) => handleChange(element.id, event)} />
        <input type="number" name="percentage" placeholder="Percentage" value={element.percentage} onChange={(event) => handleChange(element.id, event)} />
        <button onClick={() => deleteElement(element.id)}>Delete</button>
    </li>)


    React.useEffect(updateActivationPercentage, [activationElements])

    function updateActivationPercentage() {
        let activationPercentage = 1.0
        activationElements.forEach(element => activationPercentage *= element.percentage)
        setFinalActivationPercentage(activationPercentage)
    }
    function handleUpdate() {

        let activatedUsers = Array(props.acquisitions.length).fill(0)
        props.acquisitions.forEach((acquiredUsers, index) => {
            activatedUsers[index] = acquiredUsers * finalActivationPercentage
        })
        props.setUsersAfterActivation(activatedUsers)
    }

    return (
        <>
            <form>
                <ul>{activationInputs}</ul>
            </form>

            <div>
                <button onClick={addActivationElement}>Add Activation Stage</button>
                <button onClick={handleUpdate}>Update</button>
            </div>
        </>

    )
}