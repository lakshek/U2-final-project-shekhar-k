// define reusable component with destructured props
export default function TableRow({ age, milestone }) {

    return (

        <tr>
            <td>{age}</td>
            <td>{milestone}</td>
        </tr>

    )

}