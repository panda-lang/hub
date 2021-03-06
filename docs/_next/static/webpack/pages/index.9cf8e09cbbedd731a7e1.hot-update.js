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
  console.log('profile');
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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwiY29uc29sZSIsImxvZyIsInNtIiwiYmFzZSIsIm91dGxpbmUiLCJOYXZpZ2F0aW9uIiwiTmF2aWdhdGlvbkl0ZW0iLCJocmVmIiwibGFiZWwiLCJQcm9maWxlIiwidXNlQXV0aCIsImdldEp3dCIsIkxvZ2luIiwiUHJvZmlsZU1lbnUiLCJ1c2VyIiwiaGFuZGxlTG9nb3V0IiwicHJvZmlsZSIsIkJ1dHRvbiIsInVzZXJuYW1lIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQWVBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7O0FBRUEsSUFBTUEsTUFBTSxHQUFHLFNBQVRBLE1BQVMsQ0FBQ0MsS0FBRCxFQUFXO0FBQUE7O0FBQ3hCLE1BQU1DLE9BQU8sR0FBR0MsMEVBQWlCLENBQUMsU0FBRCxFQUFZLFVBQVosQ0FBakM7QUFDQSxNQUFNQyxLQUFLLEdBQUdELDBFQUFpQixDQUFDLE9BQUQsRUFBVSxPQUFWLENBQS9CO0FBQ0FFLFNBQU8sQ0FBQ0MsR0FBUixDQUFZLFNBQVo7QUFFQSxzQkFDRSxxRUFBQyxxRUFBRDtBQUNFLFVBQU0sRUFBQyxHQURUO0FBRUUsVUFBTSxFQUFFO0FBQUVDLFFBQUUsRUFBRSxRQUFOO0FBQWdCQyxVQUFJLEVBQUU7QUFBdEIsS0FGVjtBQUdFLE1BQUUsRUFBRU4sT0FITjtBQUlFLFNBQUssRUFBRUUsS0FKVDtBQUtFLFVBQU0sRUFBQyxJQUxUO0FBTUUsWUFBUSxFQUFDO0FBTlgsS0FPTUgsS0FQTjtBQUFBLDJCQVNFLHFFQUFDLG1FQUFEO0FBQ0UsbUJBQWEsRUFBRTtBQUFFTSxVQUFFLEVBQUUsS0FBTjtBQUFhQyxZQUFJLEVBQUU7QUFBbkIsT0FEakI7QUFFRSxvQkFBYyxF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TyxDQUFDRTtBQURYO0FBQUE7QUFBQTtBQUFBO0FBQUEsZUFERixlQUlFLHFFQUFDLHlEQUFEO0FBQUEsZ0NBQ0UscUVBQUMsNERBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFERixlQUVFLHFFQUFDLG9EQUFEO0FBQUssa0JBQVEsRUFBQyxNQUFkO0FBQUEsK0NBRUUscUVBQUMscUVBQUQ7QUFBYSxtQkFBTyxFQUFDO0FBQXJCO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBRkY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQUZGLGVBTUUscUVBQUMsNERBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFORixlQU9FLHFFQUFDLDBEQUFEO0FBQUEsa0NBQ0UscUVBQUMseURBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBREYsZUFFRSxxRUFBQyx5REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFGRixlQUdFLHFFQUFDLHlEQUFEO0FBQVUsbUJBQU8sRUFBRUgsWUFBbkI7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBSEY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQVBGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxlQUpGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQURGO0FBQUE7QUFBQTtBQUFBO0FBQUEsV0FERjtBQXNCRCxDQTFCRDs7SUFBTUYsVztVQUMyQkgsK0Q7OztNQUQzQkcsVztBQTRCU2xCLHFFQUFmIiwiZmlsZSI6InN0YXRpYy93ZWJwYWNrL3BhZ2VzL2luZGV4LjljZjhlMDljYmJlZGQ3MzFhN2UxLmhvdC11cGRhdGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge1xuICBGbGV4LFxuICBCb3gsXG4gIEhlYWRpbmcsXG4gIExpbmssXG4gIEJ1dHRvbixcbiAgVGV4dCxcbiAgTWVudSxcbiAgTWVudUJ1dHRvbixcbiAgTWVudUl0ZW0sXG4gIE1lbnVHcm91cCxcbiAgTWVudUxpc3QsXG4gIE1lbnVEaXZpZGVyLFxuICB1c2VDb2xvck1vZGVWYWx1ZSxcbn0gZnJvbSAnQGNoYWtyYS11aS9yZWFjdCdcbmltcG9ydCB7IENvbnRhaW5lciwgQ29udGVudCB9IGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L0NvbnRhaW5lcidcbmltcG9ydCB7IEZhR2l0aHViIH0gZnJvbSAncmVhY3QtaWNvbnMvZmEnXG5pbXBvcnQgeyBNZEFycm93RHJvcERvd24gfSBmcm9tICdyZWFjdC1pY29ucy9tZCdcblxuaW1wb3J0IFRoZW1lU3dpdGNoIGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L1RoZW1lU3dpdGNoJ1xuaW1wb3J0IHsgdXNlQXV0aCB9IGZyb20gJ2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyJ1xuXG5jb25zdCBIZWFkZXIgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgYmdDb2xvciA9IHVzZUNvbG9yTW9kZVZhbHVlKCdncmF5LjUwJywgJ2dyYXkuOTAwJylcbiAgY29uc3QgY29sb3IgPSB1c2VDb2xvck1vZGVWYWx1ZSgnYmxhY2snLCAnd2hpdGUnKVxuICBjb25zb2xlLmxvZygncHJvZmlsZScpXG5cbiAgcmV0dXJuIChcbiAgICA8Q29udGFpbmVyXG4gICAgICB6SW5kZXg9XCIxXCJcbiAgICAgIGhlaWdodD17eyBzbTogJzQuNXJlbScsIGJhc2U6ICdhdXRvJyB9fVxuICAgICAgYmc9e2JnQ29sb3J9XG4gICAgICBjb2xvcj17Y29sb3J9XG4gICAgICBzaGFkb3c9XCJzbVwiXG4gICAgICBwYWRkaW5nWD1cIjM3cHhcIlxuICAgICAgey4uLnByb3BzfVxuICAgID5cbiAgICAgIDxDb250ZW50XG4gICAgICAgIGZsZXhEaXJlY3Rpb249e3sgc206ICdyb3cnLCBiYXNlOiAnY29sdW1uJyB9fVxuICAgICAgICBqdXN0aWZ5Q29udGVudD1cInNwYWNlLWJldHdlZW5cIlxuICAgICAgICBhbGlnbkl0ZW1zPVwiY2VudGVyXCJcbiAgICAgID5cbiAgICAgICAgPEJveFxuICAgICAgICAgIHdpZHRoPXt7IHNtOiAnMTAwcHgnLCBiYXNlOiAnYXV0bycgfX1cbiAgICAgICAgICBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19XG4gICAgICAgID5cbiAgICAgICAgICA8TGluayBocmVmPVwiL1wiIF9mb2N1cz17eyBvdXRsaW5lOiAwIH19PlxuICAgICAgICAgICAgPEhlYWRpbmcgZm9udFNpemU9XCIxLjVyZW1cIiBwYWRkaW5nUmlnaHQ9XCIwcHhcIj5cbiAgICAgICAgICAgICAgSHViXG4gICAgICAgICAgICA8L0hlYWRpbmc+XG4gICAgICAgICAgPC9MaW5rPlxuICAgICAgICA8L0JveD5cbiAgICAgICAgPE5hdmlnYXRpb24gcGFkZGluZ1k9e3sgc206ICcwcHgnLCBiYXNlOiAnN3B4JyB9fSAvPlxuICAgICAgICA8UHJvZmlsZSBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19IC8+XG4gICAgICA8L0NvbnRlbnQ+XG4gICAgPC9Db250YWluZXI+XG4gIClcbn1cblxuY29uc3QgTmF2aWdhdGlvbiA9IChwcm9wcykgPT4ge1xuICByZXR1cm4gKFxuICAgIDxGbGV4IHsuLi5wcm9wc30+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJBYm91dFwiIGhyZWY9XCIvYWJvdXRcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiRG9jc1wiIGhyZWY9XCIvZG9jc1wiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJFeHBsb3JlXCIgaHJlZj1cIi9leHBsb3JlXCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIlN1cHBvcnRcIiBocmVmPVwiaHR0cHM6Ly9wYW5kYS1sYW5nLm9yZy9zdXBwb3J0L1wiIC8+XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmNvbnN0IE5hdmlnYXRpb25JdGVtID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPExpbmtcbiAgICAgIGhyZWY9e3Byb3BzLmhyZWZ9XG4gICAgICBmb250V2VpZ2h0PVwiYm9sZFwiXG4gICAgICBwYWRkaW5nWD1cIjEzcHhcIlxuICAgICAgX2ZvY3VzPXt7IG91dGxpbmU6IDAgfX1cbiAgICAgIHsuLi5wcm9wc31cbiAgICA+XG4gICAgICB7cHJvcHMubGFiZWx9XG4gICAgPC9MaW5rPlxuICApXG59XG5cbmNvbnN0IFByb2ZpbGUgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgeyBnZXRKd3QgfSA9IHVzZUF1dGgoKVxuICBjb25zb2xlLmxvZygncHJvZmlsZScpXG4gIHJldHVybiAoXG4gICAgPEZsZXggYWxpZ25JdGVtcz1cImNlbnRlclwiIGRpc3BsYXk9e3sgc206ICdmbGV4JywgYmFzZTogJ25vbmUnIH19IHsuLi5wcm9wc30+XG4gICAgICB7IGdldEp3dCgpID8gPFByb2ZpbGVNZW51Lz4gOiA8TG9naW4gLz4gfVxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5jb25zdCBMb2dpbiA9IChwcm9wcykgPT4ge1xuICByZXR1cm4gKFxuICAgIDxMaW5rIGhyZWY9XCJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aG9yaXplL2dpdGh1YlwiIHsuLi5wcm9wc30+XG4gICAgICA8RmxleCB3aWR0aD1cIjEwMHB4XCI+XG4gICAgICAgIDxUZXh0PlNpZ24gSW48L1RleHQ+XG4gICAgICAgIDxUZXh0IG1hcmdpblRvcD1cIjRweFwiIG1hcmdpbkxlZnQ9XCI3cHhcIj5cbiAgICAgICAgICA8RmFHaXRodWIgZm9udFNpemU9XCIxLjE1cmVtXCIgLz5cbiAgICAgICAgPC9UZXh0PlxuICAgICAgPC9GbGV4PlxuICAgIDwvTGluaz5cbiAgKVxufVxuXG5jb25zdCBQcm9maWxlTWVudSA9IChwcm9wcykgPT4ge1xuICBjb25zdCB7IHVzZXIsIGhhbmRsZUxvZ291dCB9ID0gdXNlQXV0aCgpXG4gIGNvbnN0IHByb2ZpbGUgPSB1c2VyIHx8IHt9XG5cbiAgcmV0dXJuIChcbiAgICA8RmxleD5cbiAgICAgIDxNZW51PlxuICAgICAgICA8TWVudUJ1dHRvbiBhcz17QnV0dG9ufSByaWdodEljb249ezxNZEFycm93RHJvcERvd24gLz59PlxuICAgICAgICAgIHtwcm9maWxlLnVzZXJuYW1lfVxuICAgICAgICA8L01lbnVCdXR0b24+XG4gICAgICAgIDxNZW51TGlzdD5cbiAgICAgICAgICA8TWVudURpdmlkZXIgLz5cbiAgICAgICAgICA8Qm94IHBhZGRpbmdYPVwiMTJweFwiPlxuICAgICAgICAgICAgRGFyayBtb2RlXG4gICAgICAgICAgICA8VGhlbWVTd2l0Y2ggbWFyZ2luWD1cIjdweFwiIC8+XG4gICAgICAgICAgPC9Cb3g+XG4gICAgICAgICAgPE1lbnVEaXZpZGVyIC8+XG4gICAgICAgICAgPE1lbnVHcm91cD5cbiAgICAgICAgICAgIDxNZW51SXRlbT5NeSBwcm9maWxlPC9NZW51SXRlbT5cbiAgICAgICAgICAgIDxNZW51SXRlbT5TZXR0aW5ncyA8L01lbnVJdGVtPlxuICAgICAgICAgICAgPE1lbnVJdGVtIG9uQ2xpY2s9e2hhbmRsZUxvZ291dH0+TG9nb3V0PC9NZW51SXRlbT5cbiAgICAgICAgICA8L01lbnVHcm91cD5cbiAgICAgICAgPC9NZW51TGlzdD5cbiAgICAgIDwvTWVudT5cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuZXhwb3J0IGRlZmF1bHQgSGVhZGVyXG4iXSwic291cmNlUm9vdCI6IiJ9