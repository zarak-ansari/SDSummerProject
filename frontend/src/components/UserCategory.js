import React from "react"
import AcquisitionElements from "./AcquisitionElements"
import Activation from "./Activation"
import Chart from "./Chart"
import Retention from "./Retention"
export default function UserCategory(props) {
    const numberOfPeriods = props.numberOfPeriods
    const [acquisitions, setAcquisitions] = React.useState(Array(numberOfPeriods).fill(0))
    const [usersAfterActivation, setUsersAfterActivation] = React.useState(Array(numberOfPeriods).fill(0))
    const [totalUsersRetained, setTotalUsersRetained] = React.useState(Array(numberOfPeriods).fill(0))


    return (
        <>
            <AcquisitionElements numberOfPeriods={numberOfPeriods} handleUpdate={setAcquisitions} />
            <Chart data={acquisitions} />

            <Activation acquisitions={acquisitions} setUsersAfterActivation={setUsersAfterActivation} />
            <Chart data={usersAfterActivation} />

            <Retention numberOfPeriods={numberOfPeriods} activatedUsers={usersAfterActivation} setRetainedUsers={setTotalUsersRetained} />
            <table>
                <tbody>
                    {totalUsersRetained.map((datapoint, index) => <tr key={index}><td>{index}</td><td>{datapoint}</td></tr>)}
                </tbody>
            </table>
            <Chart data={totalUsersRetained} />

        </>
    )
}