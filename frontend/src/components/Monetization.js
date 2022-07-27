import React from "react"

function Monetization(props) {
    // average revenue per user per period * percentage of paid users
    const [revenuePerUserPerPeriod, setRevenuePerUserPerPeriod] = React.useState(0)
    const [percentageOfPaidUsers, setPercentageOfPaidUsers] = React.useState(0.0)

    function calculateRevenue() {
        props.setTotalRevenue(props.usersAfterCompoundingGrowth.map(users => users * revenuePerUserPerPeriod * percentageOfPaidUsers))

    }

    return (
        <>
            <input
                type="number"
                name="revenuePerUserPerPeriod"
                value={revenuePerUserPerPeriod}
                placeholder="Revenue Per User Per Period"
                onChange={(event) => setRevenuePerUserPerPeriod(event.target.value)}
            />
            <input
                type="number"
                name="percentageOfPaidUsers"
                value={percentageOfPaidUsers}
                placeholder="Percentage of Paid Users"
                onChange={(event) => setPercentageOfPaidUsers(event.target.value)}
            />
            <button onClick={calculateRevenue}>Update Data</button>
        </>
    )


}

export default Monetization