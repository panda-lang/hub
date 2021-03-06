webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/layout/Header.js":
/*!*****************************************!*\
  !*** ./src/components/layout/Header.js ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @chakra-ui/react */ "./node_modules/@chakra-ui/react/dist/esm/index.js");
/* harmony import */ var components_layout_Container__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! components/layout/Container */ "./src/components/layout/Container.js");
/* harmony import */ var react_icons_fa__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! react-icons/fa */ "./node_modules/react-icons/fa/index.esm.js");
/* harmony import */ var react_icons_md__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react-icons/md */ "./node_modules/react-icons/md/index.esm.js");
/* harmony import */ var components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! components/layout/ThemeSwitch */ "./src/components/layout/ThemeSwitch.js");
/* harmony import */ var components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! components/AuthProvider */ "./src/components/AuthProvider.js");



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\layout\\Header.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$(),
    _s3 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }








var Header = function Header(props) {
  _s();

  var bgColor = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('gray.50', 'gray.900');
  var color = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('black', 'white');
  console.log('header');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Container"], _objectSpread(_objectSpread({
    zIndex: "1",
    height: {
      sm: '4.5rem',
      base: 'auto'
    },
    bg: bgColor,
    color: color,
    shadow: "sm",
    paddingX: "37px"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Content"], {
      flexDirection: {
        sm: 'row',
        base: 'column'
      },
      justifyContent: "space-between",
      alignItems: "center",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
        width: {
          sm: '100px',
          base: 'auto'
        },
        paddingY: {
          sm: '0px',
          base: '7px'
        },
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], {
          href: "/",
          _focus: {
            outline: 0
          },
          children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Heading"], {
            fontSize: "1.5rem",
            paddingRight: "0px",
            children: "Hub"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 48,
            columnNumber: 13
          }, _this)
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 47,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 43,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Navigation, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 53,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Profile, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 54,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 38,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 29,
    columnNumber: 5
  }, _this);
};

_s(Header, "GxINmYQjSw+rm7TrtZAlo2dz7DQ=", false, function () {
  return [_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"], _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"]];
});

_c = Header;

var Navigation = function Navigation(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({}, props), {}, {
    children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "About",
      href: "/about"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 63,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Docs",
      href: "/docs"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 64,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Explore",
      href: "/explore"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 65,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Support",
      href: "https://panda-lang.org/support/"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 66,
      columnNumber: 7
    }, _this)]
  }), void 0, true, {
    fileName: _jsxFileName,
    lineNumber: 62,
    columnNumber: 5
  }, _this);
};

_c2 = Navigation;

var NavigationItem = function NavigationItem(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: props.href,
    fontWeight: "bold",
    paddingX: "13px",
    _focus: {
      outline: 0
    }
  }, props), {}, {
    children: props.label
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 73,
    columnNumber: 5
  }, _this);
};

_c3 = NavigationItem;

var Profile = function Profile(props) {
  _s2();

  var _useAuth = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      getJwt = _useAuth.getJwt;

  console.log('profile');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({
    alignItems: "center",
    display: {
      sm: 'flex',
      base: 'none'
    }
  }, props), {}, {
    children: getJwt() ? /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(ProfileMenu, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 90,
      columnNumber: 20
    }, _this) : /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Login, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 90,
      columnNumber: 37
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 89,
    columnNumber: 5
  }, _this);
};

_s2(Profile, "BSxlt9l5nac89oJTjXT7xtNKQ4Y=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c4 = Profile;

var Login = function Login(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: "http://localhost:8080/authorize/github"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
      width: "100px",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        children: "Sign In"
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 99,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        marginTop: "4px",
        marginLeft: "7px",
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_fa__WEBPACK_IMPORTED_MODULE_4__["FaGithub"], {
          fontSize: "1.15rem"
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 101,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 100,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 98,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 97,
    columnNumber: 5
  }, _this);
};

_c5 = Login;

var ProfileMenu = function ProfileMenu(props) {
  _s3();

  var _useAuth2 = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      user = _useAuth2.user,
      handleLogout = _useAuth2.handleLogout;

  var profile = user || {};
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Menu"], {
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuButton"], {
        as: _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Button"],
        rightIcon: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_md__WEBPACK_IMPORTED_MODULE_5__["MdArrowDropDown"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 115,
          columnNumber: 44
        }, _this),
        children: profile.username
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 115,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
        children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 119,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
          paddingX: "12px",
          children: ["Dark mode", /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__["default"], {
            marginX: "7px"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 122,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 120,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 124,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuGroup"], {
          children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "My profile"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 126,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "Settings "
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 127,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            onClick: handleLogout,
            children: "Logout"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 128,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 125,
          columnNumber: 11
        }, _this)]
      }, void 0, true, {
        fileName: _jsxFileName,
        lineNumber: 118,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 114,
      columnNumber: 7
    }, _this)
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 113,
    columnNumber: 5
  }, _this);
};

_s3(ProfileMenu, "mSW+RoajZBiJZe2sByCSxGQKiOI=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c6 = ProfileMenu;
/* harmony default export */ __webpack_exports__["default"] = (Header);

var _c, _c2, _c3, _c4, _c5, _c6;

$RefreshReg$(_c, "Header");
$RefreshReg$(_c2, "Navigation");
$RefreshReg$(_c3, "NavigationItem");
$RefreshReg$(_c4, "Profile");
$RefreshReg$(_c5, "Login");
$RefreshReg$(_c6, "ProfileMenu");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwiY29uc29sZSIsImxvZyIsInNtIiwiYmFzZSIsIm91dGxpbmUiLCJOYXZpZ2F0aW9uIiwiTmF2aWdhdGlvbkl0ZW0iLCJocmVmIiwibGFiZWwiLCJQcm9maWxlIiwidXNlQXV0aCIsImdldEp3dCIsIkxvZ2luIiwiUHJvZmlsZU1lbnUiLCJ1c2VyIiwiaGFuZGxlTG9nb3V0IiwicHJvZmlsZSIsIkJ1dHRvbiIsInVzZXJuYW1lIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQWVBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7O0FBRUEsSUFBTUEsTUFBTSxHQUFHLFNBQVRBLE1BQVMsQ0FBQ0MsS0FBRCxFQUFXO0FBQUE7O0FBQ3hCLE1BQU1DLE9BQU8sR0FBR0MsMEVBQWlCLENBQUMsU0FBRCxFQUFZLFVBQVosQ0FBakM7QUFDQSxNQUFNQyxLQUFLLEdBQUdELDBFQUFpQixDQUFDLE9BQUQsRUFBVSxPQUFWLENBQS9CO0FBQ0FFLFNBQU8sQ0FBQ0MsR0FBUixDQUFZLFFBQVo7QUFFQSxzQkFDRSxxRUFBQyxxRUFBRDtBQUNFLFVBQU0sRUFBQyxHQURUO0FBRUUsVUFBTSxFQUFFO0FBQUVDLFFBQUUsRUFBRSxRQUFOO0FBQWdCQyxVQUFJLEVBQUU7QUFBdEIsS0FGVjtBQUdFLE1BQUUsRUFBRU4sT0FITjtBQUlFLFNBQUssRUFBRUUsS0FKVDtBQUtFLFVBQU0sRUFBQyxJQUxUO0FBTUUsWUFBUSxFQUFDO0FBTlgsS0FPTUgsS0FQTjtBQUFBLDJCQVNFLHFFQUFDLG1FQUFEO0FBQ0UsbUJBQWEsRUFBRTtBQUFFTSxVQUFFLEVBQUUsS0FBTjtBQUFhQyxZQUFJLEVBQUU7QUFBbkIsT0FEakI7QUFFRSxvQkFBYyxF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TyxDQUFDRTtBQURYO0FBQUE7QUFBQTtBQUFBO0FBQUEsZUFERixlQUlFLHFFQUFDLHlEQUFEO0FBQUEsZ0NBQ0UscUVBQUMsNERBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFERixlQUVFLHFFQUFDLG9EQUFEO0FBQUssa0JBQVEsRUFBQyxNQUFkO0FBQUEsK0NBRUUscUVBQUMscUVBQUQ7QUFBYSxtQkFBTyxFQUFDO0FBQXJCO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBRkY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQUZGLGVBTUUscUVBQUMsNERBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFORixlQU9FLHFFQUFDLDBEQUFEO0FBQUEsa0NBQ0UscUVBQUMseURBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBREYsZUFFRSxxRUFBQyx5REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFGRixlQUdFLHFFQUFDLHlEQUFEO0FBQVUsbUJBQU8sRUFBRUgsWUFBbkI7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBSEY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQVBGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxlQUpGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQURGO0FBQUE7QUFBQTtBQUFBO0FBQUEsV0FERjtBQXNCRCxDQTFCRDs7SUFBTUYsVztVQUMyQkgsK0Q7OztNQUQzQkcsVztBQTRCU2xCLHFFQUFmIiwiZmlsZSI6InN0YXRpYy93ZWJwYWNrL3BhZ2VzL2luZGV4LjU3OWYyNDRjMTk4M2ZiYWU4N2M2LmhvdC11cGRhdGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge1xuICBGbGV4LFxuICBCb3gsXG4gIEhlYWRpbmcsXG4gIExpbmssXG4gIEJ1dHRvbixcbiAgVGV4dCxcbiAgTWVudSxcbiAgTWVudUJ1dHRvbixcbiAgTWVudUl0ZW0sXG4gIE1lbnVHcm91cCxcbiAgTWVudUxpc3QsXG4gIE1lbnVEaXZpZGVyLFxuICB1c2VDb2xvck1vZGVWYWx1ZSxcbn0gZnJvbSAnQGNoYWtyYS11aS9yZWFjdCdcbmltcG9ydCB7IENvbnRhaW5lciwgQ29udGVudCB9IGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L0NvbnRhaW5lcidcbmltcG9ydCB7IEZhR2l0aHViIH0gZnJvbSAncmVhY3QtaWNvbnMvZmEnXG5pbXBvcnQgeyBNZEFycm93RHJvcERvd24gfSBmcm9tICdyZWFjdC1pY29ucy9tZCdcblxuaW1wb3J0IFRoZW1lU3dpdGNoIGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L1RoZW1lU3dpdGNoJ1xuaW1wb3J0IHsgdXNlQXV0aCB9IGZyb20gJ2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyJ1xuXG5jb25zdCBIZWFkZXIgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgYmdDb2xvciA9IHVzZUNvbG9yTW9kZVZhbHVlKCdncmF5LjUwJywgJ2dyYXkuOTAwJylcbiAgY29uc3QgY29sb3IgPSB1c2VDb2xvck1vZGVWYWx1ZSgnYmxhY2snLCAnd2hpdGUnKVxuICBjb25zb2xlLmxvZygnaGVhZGVyJylcblxuICByZXR1cm4gKFxuICAgIDxDb250YWluZXJcbiAgICAgIHpJbmRleD1cIjFcIlxuICAgICAgaGVpZ2h0PXt7IHNtOiAnNC41cmVtJywgYmFzZTogJ2F1dG8nIH19XG4gICAgICBiZz17YmdDb2xvcn1cbiAgICAgIGNvbG9yPXtjb2xvcn1cbiAgICAgIHNoYWRvdz1cInNtXCJcbiAgICAgIHBhZGRpbmdYPVwiMzdweFwiXG4gICAgICB7Li4ucHJvcHN9XG4gICAgPlxuICAgICAgPENvbnRlbnRcbiAgICAgICAgZmxleERpcmVjdGlvbj17eyBzbTogJ3JvdycsIGJhc2U6ICdjb2x1bW4nIH19XG4gICAgICAgIGp1c3RpZnlDb250ZW50PVwic3BhY2UtYmV0d2VlblwiXG4gICAgICAgIGFsaWduSXRlbXM9XCJjZW50ZXJcIlxuICAgICAgPlxuICAgICAgICA8Qm94XG4gICAgICAgICAgd2lkdGg9e3sgc206ICcxMDBweCcsIGJhc2U6ICdhdXRvJyB9fVxuICAgICAgICAgIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX1cbiAgICAgICAgPlxuICAgICAgICAgIDxMaW5rIGhyZWY9XCIvXCIgX2ZvY3VzPXt7IG91dGxpbmU6IDAgfX0+XG4gICAgICAgICAgICA8SGVhZGluZyBmb250U2l6ZT1cIjEuNXJlbVwiIHBhZGRpbmdSaWdodD1cIjBweFwiPlxuICAgICAgICAgICAgICBIdWJcbiAgICAgICAgICAgIDwvSGVhZGluZz5cbiAgICAgICAgICA8L0xpbms+XG4gICAgICAgIDwvQm94PlxuICAgICAgICA8TmF2aWdhdGlvbiBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19IC8+XG4gICAgICAgIDxQcm9maWxlIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX0gLz5cbiAgICAgIDwvQ29udGVudD5cbiAgICA8L0NvbnRhaW5lcj5cbiAgKVxufVxuXG5jb25zdCBOYXZpZ2F0aW9uID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPEZsZXggey4uLnByb3BzfT5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkFib3V0XCIgaHJlZj1cIi9hYm91dFwiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJEb2NzXCIgaHJlZj1cIi9kb2NzXCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkV4cGxvcmVcIiBocmVmPVwiL2V4cGxvcmVcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiU3VwcG9ydFwiIGhyZWY9XCJodHRwczovL3BhbmRhLWxhbmcub3JnL3N1cHBvcnQvXCIgLz5cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuY29uc3QgTmF2aWdhdGlvbkl0ZW0gPSAocHJvcHMpID0+IHtcbiAgcmV0dXJuIChcbiAgICA8TGlua1xuICAgICAgaHJlZj17cHJvcHMuaHJlZn1cbiAgICAgIGZvbnRXZWlnaHQ9XCJib2xkXCJcbiAgICAgIHBhZGRpbmdYPVwiMTNweFwiXG4gICAgICBfZm9jdXM9e3sgb3V0bGluZTogMCB9fVxuICAgICAgey4uLnByb3BzfVxuICAgID5cbiAgICAgIHtwcm9wcy5sYWJlbH1cbiAgICA8L0xpbms+XG4gIClcbn1cblxuY29uc3QgUHJvZmlsZSA9IChwcm9wcykgPT4ge1xuICBjb25zdCB7IGdldEp3dCB9ID0gdXNlQXV0aCgpXG4gIGNvbnNvbGUubG9nKCdwcm9maWxlJylcbiAgcmV0dXJuIChcbiAgICA8RmxleCBhbGlnbkl0ZW1zPVwiY2VudGVyXCIgZGlzcGxheT17eyBzbTogJ2ZsZXgnLCBiYXNlOiAnbm9uZScgfX0gey4uLnByb3BzfT5cbiAgICAgIHsgZ2V0Snd0KCkgPyA8UHJvZmlsZU1lbnUvPiA6IDxMb2dpbiAvPiB9XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmNvbnN0IExvZ2luID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPExpbmsgaHJlZj1cImh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9hdXRob3JpemUvZ2l0aHViXCIgey4uLnByb3BzfT5cbiAgICAgIDxGbGV4IHdpZHRoPVwiMTAwcHhcIj5cbiAgICAgICAgPFRleHQ+U2lnbiBJbjwvVGV4dD5cbiAgICAgICAgPFRleHQgbWFyZ2luVG9wPVwiNHB4XCIgbWFyZ2luTGVmdD1cIjdweFwiPlxuICAgICAgICAgIDxGYUdpdGh1YiBmb250U2l6ZT1cIjEuMTVyZW1cIiAvPlxuICAgICAgICA8L1RleHQ+XG4gICAgICA8L0ZsZXg+XG4gICAgPC9MaW5rPlxuICApXG59XG5cbmNvbnN0IFByb2ZpbGVNZW51ID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IHsgdXNlciwgaGFuZGxlTG9nb3V0IH0gPSB1c2VBdXRoKClcbiAgY29uc3QgcHJvZmlsZSA9IHVzZXIgfHwge31cblxuICByZXR1cm4gKFxuICAgIDxGbGV4PlxuICAgICAgPE1lbnU+XG4gICAgICAgIDxNZW51QnV0dG9uIGFzPXtCdXR0b259IHJpZ2h0SWNvbj17PE1kQXJyb3dEcm9wRG93biAvPn0+XG4gICAgICAgICAge3Byb2ZpbGUudXNlcm5hbWV9XG4gICAgICAgIDwvTWVudUJ1dHRvbj5cbiAgICAgICAgPE1lbnVMaXN0PlxuICAgICAgICAgIDxNZW51RGl2aWRlciAvPlxuICAgICAgICAgIDxCb3ggcGFkZGluZ1g9XCIxMnB4XCI+XG4gICAgICAgICAgICBEYXJrIG1vZGVcbiAgICAgICAgICAgIDxUaGVtZVN3aXRjaCBtYXJnaW5YPVwiN3B4XCIgLz5cbiAgICAgICAgICA8L0JveD5cbiAgICAgICAgICA8TWVudURpdmlkZXIgLz5cbiAgICAgICAgICA8TWVudUdyb3VwPlxuICAgICAgICAgICAgPE1lbnVJdGVtPk15IHByb2ZpbGU8L01lbnVJdGVtPlxuICAgICAgICAgICAgPE1lbnVJdGVtPlNldHRpbmdzIDwvTWVudUl0ZW0+XG4gICAgICAgICAgICA8TWVudUl0ZW0gb25DbGljaz17aGFuZGxlTG9nb3V0fT5Mb2dvdXQ8L01lbnVJdGVtPlxuICAgICAgICAgIDwvTWVudUdyb3VwPlxuICAgICAgICA8L01lbnVMaXN0PlxuICAgICAgPC9NZW51PlxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5leHBvcnQgZGVmYXVsdCBIZWFkZXJcbiJdLCJzb3VyY2VSb290IjoiIn0=