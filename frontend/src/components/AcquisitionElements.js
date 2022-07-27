import React from "react"

export default function AcquisitionElements(props) {

  const numberOfPeriods = props.numberOfPeriods

  const [linearAcquisitionElements, setLinearAcquisitionElements] = React.useState([])

  const acquisitionsInputs = linearAcquisitionElements.map(element => <li key={element.id}>
    <input type="text" name="name" placeholder="name" value={element.name} onChange={(event) => handleChangeInAcquisitionElements(element.id, event)} />
    <input type="text" name="description" placeholder="description" value={element.description} onChange={(event) => handleChangeInAcquisitionElements(element.id, event)} />
    <input type="number" name="startingValue" placeholder="Starting Value" value={element.startingValue} onChange={(event) => handleChangeInAcquisitionElements(element.id, event)} />
    <input type="number" name="incrementEachPeriod" placeholder="Increase Each Period" value={element.incrementEachPeriod} onChange={(event) => handleChangeInAcquisitionElements(element.id, event)} />
    <input type="number" name="costPerAcquisition" placeholder="Cost Per Acquisition" value={element.costPerAcquisition} onChange={(event) => handleChangeInAcquisitionElements(element.id, event)} />
    <button onClick={(event) => deleteElement(event, element.id)}>Delete</button>
  </li>)

  const handleChangeInAcquisitionElements = (id, event) => {
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
      incrementEachPeriod: 0,
      costPerAcquisition: 0
    }
  }

  function updateAcquisitionsData() {
    const acquisitionsResult = Array(numberOfPeriods).fill(0)
    const acquisitionsCostsResult = Array(numberOfPeriods).fill(0)

    linearAcquisitionElements.forEach(
      element => {
        for (var i = 0; i < numberOfPeriods; i++) {
          acquisitionsResult[i] += parseInt(element.startingValue) + (i * parseInt(element.incrementEachPeriod))
          acquisitionsCostsResult[i] += acquisitionsResult[i] * element.costPerAcquisition
        }
      }
    )
    props.setAcquisitionsData(acquisitionsResult)
    props.setAcquisitionsCost(acquisitionsCostsResult)
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
      <form>
        <ul>{acquisitionsInputs}</ul>
      </form>

      <div>
        <button onClick={addAcquisitionElement}>Add Linear Acquisition Element</button>
        <button onClick={updateAcquisitionsData}>Update Chart</button>
      </div>
    </>

  );

}