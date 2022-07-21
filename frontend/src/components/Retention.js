import React from "react"

function Retention(props) {
    const numberOfPeriods = props.numberOfPeriods
    const [maxRetentionPeriod, setMaxRetentionPeriod] = React.useState(10)
    const [decayCurve, setDecayCurve] = React.useState(Array(maxRetentionPeriod).fill(0))

    const decayCurveInputs = []

    for (var i = 0; i < maxRetentionPeriod; i++) {
        decayCurveInputs.push(
            <li key={i}><input name="decayPercentage" value={decayCurve[i]} id={i} onChange={(event) => handleChangeInDecayCurve(event)} /></li>
        )
    }

    function handleChangeInDecayCurve(event) {
        let result = [...decayCurve]
        result[event.target.id] = event.target.value
        setDecayCurve(result)
    }

    function updateRetainedUsers(e) {
        e.preventDefault()


        let result = Array(numberOfPeriods).fill(0)
        for (var i = 0; i < props.activatedUsers.length; i++) {
            for (var j = 0; j < decayCurve.length; j++) {
                if ((i + j) < props.numberOfPeriods)
                    result[i + j] += props.activatedUsers[i] * (1 - decayCurve[j])
            }
        }
        props.setRetainedUsers(result)
    }

    return (
        <form>
            <input type="number" name="maxRetentionPeriod" value={maxRetentionPeriod} onChange={(event) => setMaxRetentionPeriod(event.target.value)} />
            <ul>{decayCurveInputs}</ul>
            <button onClick={(e) => updateRetainedUsers(e)}>Calculate Users After Retention</button>
        </form>

    )
}

export default Retention