webpackHotUpdate_N_E("pages/authorized",{

/***/ "./src/pages/authorized.js":
/*!*********************************!*\
  !*** ./src/pages/authorized.js ***!
  \*********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var next_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! next/router */ "./node_modules/next/router.js");
/* harmony import */ var next_router__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(next_router__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _chakra_ui_react__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @chakra-ui/react */ "./node_modules/@chakra-ui/react/dist/esm/index.js");
/* harmony import */ var components_AuthProvider__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! components/AuthProvider */ "./src/components/AuthProvider.js");


var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\pages\\authorized.js",
    _this = undefined,
    _s = $RefreshSig$();






var Authorized = function Authorized() {
  _s();

  var _useAuth = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_4__["useAuth"])(),
      handleLogin = _useAuth.handleLogin;

  var router = Object(next_router__WEBPACK_IMPORTED_MODULE_2__["useRouter"])();
  Object(react__WEBPACK_IMPORTED_MODULE_1__["useEffect"])(function () {
    var jwt = router.query.token;

    if (jwt) {
      handleLogin(jwt);
      router.replace('/');
    }
  }, [router]);
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_3__["Link"], {
    href: "/",
    children: "Authenticating..."
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 20,
    columnNumber: 10
  }, _this);
};

_s(Authorized, "XuhSinFv3ADBaYnwO0M5rasI1zk=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_4__["useAuth"], next_router__WEBPACK_IMPORTED_MODULE_2__["useRouter"]];
});

_c = Authorized;
/* harmony default export */ __webpack_exports__["default"] = (Authorized);

var _c;

$RefreshReg$(_c, "Authorized");

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

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL3BhZ2VzL2F1dGhvcml6ZWQuanMiXSwibmFtZXMiOlsiQXV0aG9yaXplZCIsInVzZUF1dGgiLCJoYW5kbGVMb2dpbiIsInJvdXRlciIsInVzZVJvdXRlciIsInVzZUVmZmVjdCIsImp3dCIsInF1ZXJ5IiwidG9rZW4iLCJyZXBsYWNlIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O0FBQUE7QUFDQTtBQUNBO0FBRUE7O0FBRUEsSUFBTUEsVUFBVSxHQUFHLFNBQWJBLFVBQWEsR0FBTTtBQUFBOztBQUFBLGlCQUNDQyx1RUFBTyxFQURSO0FBQUEsTUFDZkMsV0FEZSxZQUNmQSxXQURlOztBQUV2QixNQUFNQyxNQUFNLEdBQUdDLDZEQUFTLEVBQXhCO0FBRUFDLHlEQUFTLENBQUMsWUFBTTtBQUNkLFFBQU1DLEdBQUcsR0FBR0gsTUFBTSxDQUFDSSxLQUFQLENBQWFDLEtBQXpCOztBQUVBLFFBQUlGLEdBQUosRUFBUztBQUNQSixpQkFBVyxDQUFDSSxHQUFELENBQVg7QUFDQUgsWUFBTSxDQUFDTSxPQUFQLENBQWUsR0FBZjtBQUNEO0FBQ0YsR0FQUSxFQU9OLENBQUNOLE1BQUQsQ0FQTSxDQUFUO0FBU0Esc0JBQU8scUVBQUMscURBQUQ7QUFBTSxRQUFJLEVBQUMsR0FBWDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxXQUFQO0FBQ0QsQ0FkRDs7R0FBTUgsVTtVQUNvQkMsK0QsRUFDVEcscUQ7OztLQUZYSixVO0FBZ0JTQSx5RUFBZiIsImZpbGUiOiJzdGF0aWMvd2VicGFjay9wYWdlcy9hdXRob3JpemVkLmNjNzYwY2U4ZGRiMGQ0ZGMyMGZjLmhvdC11cGRhdGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyB1c2VFZmZlY3QgfSBmcm9tICdyZWFjdCdcbmltcG9ydCB7IHVzZVJvdXRlciB9IGZyb20gJ25leHQvcm91dGVyJ1xuaW1wb3J0IHsgTGluayB9IGZyb20gJ0BjaGFrcmEtdWkvcmVhY3QnXG5cbmltcG9ydCB7IHVzZUF1dGggfSBmcm9tICdjb21wb25lbnRzL0F1dGhQcm92aWRlcidcblxuY29uc3QgQXV0aG9yaXplZCA9ICgpID0+IHtcbiAgY29uc3QgeyBoYW5kbGVMb2dpbiB9ID0gdXNlQXV0aCgpXG4gIGNvbnN0IHJvdXRlciA9IHVzZVJvdXRlcigpXG5cbiAgdXNlRWZmZWN0KCgpID0+IHtcbiAgICBjb25zdCBqd3QgPSByb3V0ZXIucXVlcnkudG9rZW5cblxuICAgIGlmIChqd3QpIHtcbiAgICAgIGhhbmRsZUxvZ2luKGp3dClcbiAgICAgIHJvdXRlci5yZXBsYWNlKCcvJylcbiAgICB9XG4gIH0sIFtyb3V0ZXJdKVxuXG4gIHJldHVybiA8TGluayBocmVmPVwiL1wiPkF1dGhlbnRpY2F0aW5nLi4uPC9MaW5rPlxufVxuXG5leHBvcnQgZGVmYXVsdCBBdXRob3JpemVkXG4iXSwic291cmNlUm9vdCI6IiJ9