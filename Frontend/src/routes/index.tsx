
import { createBrowserRouter, Navigate } from "react-router-dom";
import { Layout } from "../components/Layout";
import { LotsPage } from "../pages/LotsPage";
import { ProfilePage } from "../pages/ProfilePage";
import { LoginPage } from "../pages/LoginPage";
import { SignupPage } from "../pages/SignupPage";

import { DriverHomePage } from '../pages/DriverHomePage';
import { ParkingManagerHomePage } from '../pages/ParkingManagerHomePage';
import { SystemAdminHomePage } from '../pages/SystemAdminHomePage';


export const router = createBrowserRouter([
  {
    path: "/",
    element: <Navigate to="/login" replace />,
  },
  {
    path: '/driverHomePage',
    element: <Layout />,
    children: [
      {
        index: true,
        element: <DriverHomePage />,
      },
      {
        path: 'profile',
        element: <ProfilePage />,
      },
    ],
  },{
    path: '/parkingManagerHomePage',
    element: <Layout />,
    children: [
      {
        index: true,
        element: <ParkingManagerHomePage />,
      },
      {
        path: 'profile',
        element: <ProfilePage />,
      },
    ],
  },
  {
    path: '/systemAdminHomePage',
    element: <Layout />,
    children: [
      {
        index: true,
        element: <SystemAdminHomePage />,
      },
      {
        path: "profile",
        element: <ProfilePage />,
      },
    ],
  },
  {
    path: "/login",
    element: <LoginPage />,
  },
  {
    path: "/signup",
    element: <SignupPage />,
  },
]);
