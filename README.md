# Max Profit Problem
Mr. X owns a large strip of land in Mars Land. For the purposes of this problem assume that 
he has infinite land capacity. On each parcel of he can choose to develop it as per his wishes. 
He can build either Theatres, Pubs or Commercial Park. Commercial Park houses 6 
Commercial Spaces and 8 Screen Theatres.

 - A Theatre takes 5 units of time to build and covers 2x1 parcel of land.
 - A Pub takes 4 units of time to develop and covers 1x1 parcel of land.
 - A Commercial Park takes 10 units of time to build and covers 3x1 parcel of land.

 Each period of time that a building is operational it earns him money.
 <table>
   <thead>
      <tr>
         <th>Establishment</th>
         <th>Earning</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Theatre</td>
         <td>$1500</td>
      </tr>
      <tr>
         <td>Pub</td>
         <td>$1000</td>
      </tr>
      <tr>
         <td>Commercial Park</td>
         <td>$3000</td>
      </tr>
   </tbody>
</table>

He cannot have two properties being developed in parallel in one unit of time.
 - After n units of time where n is the input, he earns money based on which properties 
have been developed.
- The output should be T for Theatre followed by number developed, P for Pub 
followed by number developed and C for Commercial Park followed by number 
developed.

 ### Challenge
  - Come up with the right mix of properties based on the period of time given as input.
  <table>
   <thead>
      <tr>
         <th></th>
         <th>Test Case 1</th>
         <th>Test Case 2</th>
         <th>Test Case 3</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Time Unit</td>
         <td>7</td>
         <td>8</td>
         <td>13</td>
      </tr>
      <tr>
         <td>Earnings</td>
         <td>$3000</td>
         <td>$4500</td>
         <td>$16500</td>
      </tr>
      <tr>
         <td>Solution</td>
         <td>T:1 P:0 C:0</td>
         <td>T:1 P:0 C:0</td>
         <td>T:2 P:0 C:0</td>
      </tr>
   </tbody>
</table>
