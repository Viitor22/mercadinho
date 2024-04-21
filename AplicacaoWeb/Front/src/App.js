import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import Home from "./Pages/Home";
import Login from "./Pages/Login";

const rotas = createBrowserRouter([
  {
    path: '/',
    element: <Login></Login>
  },
  {
    path: '/novo',
    element: <Home></Home>
  }
])

function App() {
  return (
    <RouterProvider router={rotas}></RouterProvider>
  );
}

export default App;
