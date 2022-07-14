import React from "react"
import Chart from "./Chart"

export default function AcquisitionElements() {

  let numberOfPeriods = 10

  const [linearAcquisitionElements, setLinearAcquisitionElements] = React.useState([])
  const [acquisitionData, setAcquisitionData] = React.useState(Array(numberOfPeriods).fill(0))

  const acquisitionsInputs = linearAcquisitionElements.map(element => <li key={element.id}>
    <input type="text" name="name" placeholder="name" value={element.name} onChange={(event) => handleChange(element.id, event)} />
    <input type="text" name="description" placeholder="description" value={element.description} onChange={(event) => handleChange(element.id, event)} />
    <input type="number" name="startingValue" placeholder="Starting Value" value={element.startingValue} onChange={(event) => handleChange(element.id, event)} />
    <input type="number" name="incrementEachPeriod" placeholder="Increase Each Period" value={element.incrementEachPeriod} onChange={(event) => handleChange(element.id, event)} />
    <button onClick={(event) => deleteElement(event, element.id)}>Delete</button>
  </li>)

  const handleChange = (id, event) => {
    event.preventDefault()
    let data = [...linearAcquisitionElements]
    data[id][event.target.name] = event.target.value
    setLinearAcquisitionElements(data)
  }

  function createNewAcquisitionElement() {
    return {
      id: linearAcquisitionElements.length,
      name: "",
      description: "",
      startingValue: 0,
      incrementEachPeriod: 0
    }
  }

  function updateAcquisitionsData() {
    const result = Array(numberOfPeriods).fill(0)
    linearAcquisitionElements.forEach(
      element => {
        for (var i = 0; i < numberOfPeriods; i++) {
          result[i] += parseInt(element.startingValue) + (i * parseInt(element.incrementEachPeriod))
        }
      }
    )
    setAcquisitionData(result)
  }

  function addAcquisitionElement() {
    const newElement = createNewAcquisitionElement()
    setLinearAcquisitionElements(prevElements => [...prevElements, newElement])
  }

  function deleteElement(event, id) {
    setLinearAcquisitionElements(prev => prev.filter(element => element.id !== id))
  }


  return (
    <>
      <h1>Linear Acquisitions Elements</h1>
      <form>
        <ul>{acquisitionsInputs}</ul>
      </form>

      <div>
        <button onClick={addAcquisitionElement}>Add Linear Acquisition Element</button>
        <button onClick={updateAcquisitionsData}>Update Chart</button>
      </div>
      {acquisitionData.length > 0 && <Chart data={acquisitionData} />}
    </>

  );

}